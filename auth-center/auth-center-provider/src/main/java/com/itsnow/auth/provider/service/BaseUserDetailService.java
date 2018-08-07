package com.itsnow.auth.provider.service;

//import com.itsnow.auth.api.model.BaseRole;
import com.itsnow.auth.api.model.BaseUser;
import com.itsnow.auth.api.pojo.ResponseCode;
import com.itsnow.auth.api.pojo.auth.BaseUserDetail;

import com.itsnow.auth.provider.config.auth.filter.MyLoginAuthenticationFilter;
import com.itsnow.common.pojo.ResponseData;

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
//    @Autowired
//    private BaseRoleService baseRoleService;
//    @Autowired
//    private BaseModuleResourceService baseModuleResourceService;
//    @Autowired
//    private RedisTemplate<String, BaseRole> redisTemplate;
//    @Autowired
//    private RedisTemplate<String, BaseModuleResources> resourcesTemplate;

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

        // 账号密码登陆调用FeignClient根据用户名查询用户
        BaseUser myUser = new BaseUser();
        myUser.setUserName(parameter[1]);
        baseUser = baseUserService.selectOne(myUser);


        List<GrantedAuthority> authorities = new ArrayList();
        // 返回带有用户权限信息的User
        org.springframework.security.core.userdetails.User user =  new org.springframework.security.core.userdetails.User(baseUser.getUserName(),
                baseUser.getPassword(), isActive(baseUser.getUserEnabled()), true, true, true, authorities);
        return new BaseUserDetail(baseUser, user);
    }

    private boolean isActive(int active){
        return active == 1 ? true : false;
    }


}
