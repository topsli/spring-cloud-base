package com.itsnow.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableOAuth2Sso
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {


    private String logoutUrl = "http://localhost:18001/auth/logout";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .logout()
//                .logoutSuccessUrl(logoutUrl)
//                .and().authorizeRequests().anyRequest().authenticated();

                http.authorizeRequests()
                .antMatchers(
                        "/webjars/**",
                        "/resources/**",
                        "/swagger-ui.html",
                        "/swagger-resources/**",
                        "/v2/api-docs")
                .permitAll();
    }
}
