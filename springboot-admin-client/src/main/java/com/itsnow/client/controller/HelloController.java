package com.itsnow.client.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Xuekun_Li on 2018/10/24.
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/helloTo",method = RequestMethod.POST)
    public String sayHi(@RequestParam String name){
        return "Say hello to "+ name;
    }
}
