//package com.itsnow.ws.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//
///**
// * Created by Xuekun_Li on 2018/8/22.
// */
//@Configuration
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(final HttpSecurity http) throws Exception {
//        // This is not for websocket authorization, and this should most likely not be altered.
//        http
//                .httpBasic().disable()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//                .authorizeRequests().antMatchers("/stomp").permitAll()
//                .anyRequest().denyAll();
//    }
//}
