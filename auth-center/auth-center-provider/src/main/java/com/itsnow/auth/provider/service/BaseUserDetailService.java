package com.itsnow.auth.provider.service;

import com.itsnow.auth.api.pojo.auth.BaseUserDetail;
import com.itsnow.auth.provider.config.auth.filter.MyLoginAuthenticationFilter;
import com.itsnow.common.pojo.ResponseData;
import com.itsnow.main.api.mapper.model.BaseModuleResources;
import com.itsnow.main.api.mapper.model.BaseRole;
import com.itsnow.main.api.mapper.model.BaseUser;
import com.itsnow.main.api.pojo.ResponseCode;
import com.itsnow.main.client.BaseModuleResourceService;
import com.itsnow.main.client.BaseRoleService;
import com.itsnow.main.client.BaseUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Xuekun_Li on 2018/4/16.
 */
@Service
public class BaseUserDetailService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseUserService baseUserService;
    @Autowired
    private BaseRoleService baseRoleService;
    @Autowired
    private BaseModuleResourceService baseModuleResourceService;
    @Autowired
    private RedisTemplate<String, BaseRole> redisTemplate;
    @Autowired
    private RedisTemplate<String, BaseModuleResources> resourcesTemplate;

    @Override
    public UserDetails loadUserByUsername(String var1) throws UsernameNotFoundException {

        BaseUser baseUser;
        String[] parameter;
        int index = var1.indexOf("&:@");
        if (index != -1) {
            parameter = var1.split("&:@");
        }else {
            // 如果是 refresh_token 不分割
            parameter = new String[]{MyLoginAuthenticationFilter.SPRING_SECURITY_RESTFUL_TYPE_DEFAULT, var1};
        }

        // 手机验证码调用FeignClient根据电话号码查询用户
        if(MyLoginAuthenticationFilter.SPRING_SECURITY_RESTFUL_TYPE_PHONE.equals(parameter[0])){
            ResponseData<BaseUser> baseUserResponseData = baseUserService.getUserByPhone(parameter[1]);
            if(baseUserResponseData.getData() == null || !ResponseCode.SUCCESS.getCode().equals(baseUserResponseData.getCode())){
                logger.error("找不到该用户，手机号码：" + parameter[1]);
                throw new UsernameNotFoundException("找不到该用户，手机号码：" + parameter[1]);
            }
            baseUser = baseUserResponseData.getData();
        } else if(MyLoginAuthenticationFilter.SPRING_SECURITY_RESTFUL_TYPE_QR.equals(parameter[0])){
            // 扫码登陆根据token从redis查询用户
            baseUser = null;
        } else {
            // 账号密码登陆调用FeignClient根据用户名查询用户
            ResponseData<BaseUser> baseUserResponseData = baseUserService.getUserByUserName(parameter[1]);
            if(baseUserResponseData.getData() == null || !ResponseCode.SUCCESS.getCode().equals(baseUserResponseData.getCode())){
                logger.error("找不到该用户，用户名：" + parameter[1]);
                throw new UsernameNotFoundException("找不到该用户，用户名：" + parameter[1]);
            }
            baseUser = baseUserResponseData.getData();
        }


        // 调用FeignClient查询角色
//        ResponseData<List<BaseRole>> baseRoleListResponseData = baseRoleService.getRoleByUserId(baseUser.getUserId()+"");
//        List<BaseRole> roles;
//        if(baseRoleListResponseData.getData() == null ||  !ResponseCode.SUCCESS.getCode().equals(baseRoleListResponseData.getCode())){
//            logger.error("查询角色失败！");
//            roles = new ArrayList<>();
//        }else {
//            roles = baseRoleListResponseData.getData();
//        }
//
//        //调用FeignClient查询菜单
//        ResponseData<List<BaseModuleResources>> baseModuleResourceListResponseData = baseModuleResourceService.getMenusByUserId(baseUser.getUserId()+"");
//
//        // 获取用户权限列表
//        List<GrantedAuthority> authorities = convertToAuthorities(baseUser, roles);
//
//        // 存储菜单到redis
//        if( ResponseCode.SUCCESS.getCode().equals(baseModuleResourceListResponseData.getCode()) && baseModuleResourceListResponseData.getData() != null){
//            resourcesTemplate.delete(baseUser.getUserId() + "-menu");
//            baseModuleResourceListResponseData.getData().forEach(e -> {
//                resourcesTemplate.opsForList().leftPush(baseUser.getUserId() + "-menu", e);
//            });
//        }
        List<GrantedAuthority> authorities = new ArrayList();
        // 返回带有用户权限信息的User
        org.springframework.security.core.userdetails.User user =  new org.springframework.security.core.userdetails.User(baseUser.getUserName(),
                baseUser.getPassword(), isActive(baseUser.getUserEnabled()), true, true, true, authorities);
        return new BaseUserDetail(baseUser, user);
    }

    private boolean isActive(int active){
        return active == 1 ? true : false;
    }

    private List<GrantedAuthority> convertToAuthorities(BaseUser baseUser, List<BaseRole> roles) {
        List<GrantedAuthority> authorities = new ArrayList();
        // 清除 Redis 中用户的角色
        redisTemplate.delete(baseUser.getUserId()+"");
        roles.forEach(e -> {
            // 存储用户、角色信息到GrantedAuthority，并放到GrantedAuthority列表
            GrantedAuthority authority = new SimpleGrantedAuthority(e.getRoleCode());
            authorities.add(authority);
            //存储角色到redis
            redisTemplate.opsForList().rightPush(baseUser.getUserId()+"", e);
        });
        return authorities;
    }
}
