package com.itsnow.zipkin.db;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;


/**
 * Created by Xuekun_Li on 2018/6/28.
 * zipkin mysql 存储实现
 */
@EnableEurekaClient
@SpringCloudApplication
@EnableZipkinStreamServer
public class ZipkinDbApplication {
    public static void main (String[] args){
        SpringApplication.run(ZipkinDbApplication.class, args);
    }
}
