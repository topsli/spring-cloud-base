//package com.itsnow.management.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
///**
// * Created by Xuekun_Li on 2018/8/1.
// */
//@Configuration
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.antMatcher("/**").authorizeRequests().antMatchers("/", "/index**","/login**", "/webjars/**", "/error**").permitAll().anyRequest()
//                .authenticated();
//    }
//
//}
