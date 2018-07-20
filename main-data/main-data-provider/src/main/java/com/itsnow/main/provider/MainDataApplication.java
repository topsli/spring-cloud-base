package com.itsnow.main.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * Created by xuekun on 2018/4/9.
 */
@EnableResourceServer
@EnableEurekaClient
@SpringCloudApplication
public class MainDataApplication {
    public static void main (String[] args){
        SpringApplication.run(MainDataApplication.class, args);
    }
}
