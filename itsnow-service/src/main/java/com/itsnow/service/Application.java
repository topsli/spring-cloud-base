package com.itsnow.service;

import com.itsnow.service.component.UserInfoTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.client.RestTemplate;

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

    @Bean
    TaskScheduler transferScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(50);
        return scheduler;
    }

    @Autowired
    RestTemplate oauthRestTemplate;

    @Bean
    UserInfoTask userInfoTask(RestTemplate oauthRestTemplate, TaskScheduler transferScheduler) {
        return new UserInfoTask(oauthRestTemplate,transferScheduler);
    }

}