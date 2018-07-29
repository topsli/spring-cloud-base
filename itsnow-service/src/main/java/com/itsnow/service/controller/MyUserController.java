package com.itsnow.service.controller;

import com.itsnow.common.pojo.ResponseData;
import com.itsnow.main.api.pojo.ResponseCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Xuekun_Li on 2018/4/9.
 */
@RestController
public class MyUserController  {


    /**
     * 根据用户名获取用户信息
     * @param userName
     * @return
     */
    @RequestMapping(value = "/user/name/{userName}", method = RequestMethod.GET)
    public ResponseData<String> getUserByUserName(@PathVariable("userName") String userName) {

        String result = "the final userName is:"+userName;
        return new ResponseData<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), result);
    }

}
