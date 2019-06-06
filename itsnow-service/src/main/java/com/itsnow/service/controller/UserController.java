package com.itsnow.service.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@Api(value = "用户接口服务", description = "用户接口服务")
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ApiOperation(value = "查询通过 OAuth2.0 授权后获取的用户信息", notes = "通过 OAuth2.0 授权后获取的用户信息")
    @GetMapping("/principal")
    public Principal principal(Principal principal)
    {
        return principal;
    }


    @ApiOperation(value = "根据用户名查询用户信息", notes = "根据用户名查询用户信息")
    @GetMapping("/{username}")
    public String  getUserInfoByUserName(@PathVariable String username) {
       return  username+":123456";
    }

}
