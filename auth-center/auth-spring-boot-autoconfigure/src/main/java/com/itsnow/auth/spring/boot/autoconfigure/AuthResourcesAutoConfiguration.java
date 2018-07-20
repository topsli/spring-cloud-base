package com.itsnow.auth.spring.boot.autoconfigure;

import com.itsnow.auth.api.token.JwtAccessToken;
import org.springframework.boot.autoconfigure.security.oauth2.resource.JwtAccessTokenConverterConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

/**
 * Created by Xuekun_Li on 2018/5/6.
 */
@Configuration
public class AuthResourcesAutoConfiguration implements JwtAccessTokenConverterConfigurer {

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        return new JwtAccessToken();
    }

    @Override
    public void configure(JwtAccessTokenConverter jwtAccessTokenConverter) {
        jwtAccessTokenConverter.setAccessTokenConverter(jwtAccessTokenConverter());
    }
}
