package com.itsnow.main.provider.service;

import com.itsnow.db.spring.boot.autoconfigure.service.BaseService;
import com.itsnow.main.api.mapper.model.BaseUser;
import com.itsnow.main.api.mapper.model.BaseUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * Created by Xuekun_Li on 2018/4/9.
 */
@Service
public class BaseUserService extends BaseService<BaseUser>{

    @Autowired
    private BaseUserRoleService baseUserRoleService;


    /**
     * 批量重置密码
     * @param record
     * @param newPassword
     */
    @Transactional
    public void resetPassword(List<BaseUser> record, String newPassword) {
        record.forEach(e -> {
            BaseUser baseUser = new BaseUser();
            baseUser.setUserId(e.getUserId());
            baseUser.setPassword(new BCryptPasswordEncoder(6).encode(newPassword));
            baseUser.setUpdatedAt(new Date());
            updateByPrimaryKeySelective(baseUser);
        });
    }

    /**
     * 删除用户
     * @param record
     */
    @Transactional
    public void deleteBatch(List<BaseUser> record) {
        record.forEach(e -> {
            Example example = new Example(BaseUserRole.class);
            example.createCriteria().andEqualTo("userId", e.getId());
            baseUserRoleService.deleteByExample(example);
            deleteByPrimaryKey(e);
        });
    }
}
