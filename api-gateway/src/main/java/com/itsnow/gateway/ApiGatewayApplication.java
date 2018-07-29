package com.itsnow.gateway;

import com.itsnow.gateway.filter.AccessTokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * Created by Xuekun_Li on 2018/4/10.
 */
@EnableZuulProxy
@EnableResourceServer
@EnableEurekaClient
@SpringCloudApplication
public class ApiGatewayApplication {
    public static void main(String[] args){
        SpringApplication.run(ApiGatewayApplication.class, args);
    }


    @Bean
    public AccessTokenFilter accessTokenFilter(){
        return new AccessTokenFilter();
    }
}
