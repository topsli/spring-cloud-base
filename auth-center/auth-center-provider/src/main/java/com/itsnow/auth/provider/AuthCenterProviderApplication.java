package com.itsnow.auth.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * Created by Xuekun_Li on 2018/4/2.
 */

@EnableAuthorizationServer
@EnableFeignClients("com.itsnow.main.client")
@EnableEurekaClient
@SpringBootApplication
public class AuthCenterProviderApplication {
   public static void main(String[] args){
       SpringApplication.run(AuthCenterProviderApplication.class, args);
   }
}
