package com.itsnow.db.spring.boot.samples.service;

import com.itsnow.db.spring.boot.autoconfigure.service.BaseService;
import com.itsnow.db.spring.boot.samples.mapper.model.BaseUser;
import org.springframework.stereotype.Service;

/**
 * Created by Xuekun_Li on 2018/4/7.
 */
@Service
public class BaseUserService extends BaseService<BaseUser> {}
