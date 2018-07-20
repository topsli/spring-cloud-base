package com.itsnow.db.spring.boot.samples.controller;

import com.itsnow.db.spring.boot.samples.mapper.model.BaseUser;
import com.itsnow.db.spring.boot.samples.service.BaseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Xuekun_Li on 2018/4/7.
 */
@Controller
public class BaseUserController{
    @Autowired
    private BaseUserService baseUserService;

    @RequestMapping("/users")
    @ResponseBody
    public List<BaseUser> select(){
        return baseUserService.selectAll();
    }

}
