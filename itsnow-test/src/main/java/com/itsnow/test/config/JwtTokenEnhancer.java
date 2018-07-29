package com.itsnow.test.config;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Xuekun_Li on 2018/7/24.
 */
public class JwtTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {

        Map<String,Object> info = new HashMap<>();
        info.put("provider","ItsnowCompany");
        //设置附加信息
        ((DefaultOAuth2AccessToken)oAuth2AccessToken).setAdditionalInformation(info);
        return oAuth2AccessToken;
    }
}