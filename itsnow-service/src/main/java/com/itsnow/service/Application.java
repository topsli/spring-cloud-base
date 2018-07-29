package com.itsnow.service;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * Created by Xuekun_Li on 2018/7/29.
 */

@EnableResourceServer
@EnableEurekaClient
@SpringCloudApplication
public class Application {
    public static void main (String[] args){
        SpringApplication.run(Application.class, args);
    }
}