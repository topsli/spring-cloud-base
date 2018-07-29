package com.itsnow.test;

import com.itsnow.test.client.OperationDataService;
import com.itsnow.test.component.UserInfoTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by admin on 2018/4/21.
 */

@SpringBootApplication
@RestController
@EnableFeignClients("com.itsnow.test.client")
@EnableEurekaClient
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Value("${server.port}")
    String port;
    @RequestMapping("/hi")
    public String home(@RequestParam String name) {
        return "hi "+name+",i am from port:" +port;
    }

    @Bean
    TaskScheduler transferScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(50);
        return scheduler;
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

//    @Bean
//    UserInfoTask userInfoTask(   RestTemplate restTemplate,TaskScheduler transferScheduler) {
//        return new UserInfoTask(restTemplate,transferScheduler);
//    }
//
//    @Bean
//    HttpHeaders httpHeaders(){
//        HttpHeaders httpHeaders = new HttpHeaders();
//        String autho = "test:test";
//        byte[] encodedAuth = Base64.getEncoder().encode(autho.getBytes(Charset.forName("US-ASCII")));
//
//        String authHeader = "Basic "+new String(encodedAuth);
//        httpHeaders.set("Authorization",authHeader);
//        return httpHeaders;
//    }


    @Autowired
    OperationDataService operationDataService;


    @Bean
    UserInfoTask userInfoTask(OperationDataService operationDataService, TaskScheduler transferScheduler) {
        return new UserInfoTask(operationDataService,transferScheduler);
    }

}
