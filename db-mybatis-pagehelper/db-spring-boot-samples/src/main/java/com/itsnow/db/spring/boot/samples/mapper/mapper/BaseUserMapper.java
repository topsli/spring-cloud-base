package com.itsnow.db.spring.boot.samples.mapper.mapper;

import com.itsnow.db.spring.boot.samples.mapper.model.BaseUser;
import tk.mybatis.mapper.common.Mapper;


@org.apache.ibatis.annotations.Mapper
public interface BaseUserMapper extends Mapper<BaseUser> {


}