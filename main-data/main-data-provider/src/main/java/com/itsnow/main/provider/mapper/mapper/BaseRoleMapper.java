package com.itsnow.main.provider.mapper.mapper;


import com.itsnow.main.api.mapper.model.BaseRole;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface BaseRoleMapper extends Mapper<BaseRole> {
    List<BaseRole> getRoleByUserId(@Param("userId") String userId);
}