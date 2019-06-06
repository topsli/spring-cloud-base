package com.itsnow.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * Created by Xuekun_Li on 2018/10/24.
 */

@EnableEurekaClient
@SpringBootApplication
public class SpringBootClientApp   {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootClientApp.class,args);
    }

}
