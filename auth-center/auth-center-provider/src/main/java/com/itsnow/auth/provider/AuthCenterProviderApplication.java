package com.itsnow.auth.provider;

import com.itsnow.auth.api.model.BaseUser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Xuekun_Li on 2018/4/2.
 */

@EnableAuthorizationServer
@EnableFeignClients("com.itsnow.auth.provider.client")
@EnableEurekaClient
@SpringBootApplication
@RestController
public class AuthCenterProviderApplication {
   public static void main(String[] args){
       SpringApplication.run(AuthCenterProviderApplication.class, args);
   }

    @RequestMapping("/user/me")
    public Map user() {
        Map map = new HashMap();
        map.put("userName","test");
        return map;
    }
}
