package com.itsnow.mc.service;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * Created by Xuekun_Li on 2018/6/27.
 */
@SpringCloudApplication
public class McServiceApplication {
    public static void main (String[] args){
        SpringApplication.run(McServiceApplication.class, args);
    }
}
