package com.itsnow.ui.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Xuekun_Li on 2018/12/13.
 */
@RestController
public class UserController {

    @RequestMapping(value = "/user/helloTo",method = RequestMethod.GET)
    public String sayHi(@RequestParam String name){
        return "Say hello to "+ name;
    }

    @RequestMapping(value = "/user/currentUser",method = RequestMethod.GET)
    public String currentUserInfo(){
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
        String token =  details.getTokenValue();
        //String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2luZm8iOnsidXNlcklkIjoyMTcsInBhc3Nwb3J0SWQiOiIyMTciLCJ1c2VyTmFtZSI6Iml0c25vdyJ9LCJ1c2VyX25hbWUiOiJpdHNub3ciLCJzY29wZSI6WyJ1c2VyIl0sImV4cCI6MTU0NDcwODI5OCwiYXV0aG9yaXRpZXMiOlsiYWRtaW4iXSwianRpIjoiOThiYzdlMGEtYmZkOS00NzdmLWExZjktMjkxNjU2YjM1YTNiIiwiY2xpZW50X2lkIjoidGVzdCJ9.TLCP2kR0i-JLljH1AlvYgwzrT2ox9fDb1PvN-Vvo9J0lrqnjCGtTpKg06eJr4wVWIp-S1K5WDGaxtfOvSaqs7gaQwCTT7lVyyaxf41NQhtH2v7IfsGp_5GdkuwDJ_hlUukfoZIRkuZ2HYjS_9wBQgWyzv7HoAoJtXblG-bIOnz6REKlV7NJenWEbp4QO1k48Qc2jhBEk-16T5qsiyvWrB-fODEkycousv1ee5GE7Yi66OOn-u04d7cS5Nmfu67bLYt3D-vgV_TWgMTvfNhz9MqU7VSQRW5m9UsYTlgRfKUPgEkUSpple_WhXfOVs7YH7ROpBQa362cJdyrPFDKI4Bg";
        //eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2luZm8iOnsidXNlcklkIjoyMTcsInBhc3Nwb3J0SWQiOiIyMTciLCJ1c2VyTmFtZSI6Iml0c25vdyJ9LCJ1c2VyX25hbWUiOiJpdHNub3ciLCJzY29wZSI6WyJ1c2VyIl0sImV4cCI6MTU0NDcwODI5OCwiYXV0aG9yaXRpZXMiOlsiYWRtaW4iXSwianRpIjoiOThiYzdlMGEtYmZkOS00NzdmLWExZjktMjkxNjU2YjM1YTNiIiwiY2xpZW50X2lkIjoidGVzdCJ9.TLCP2kR0i-JLljH1AlvYgwzrT2ox9fDb1PvN-Vvo9J0lrqnjCGtTpKg06eJr4wVWIp-S1K5WDGaxtfOvSaqs7gaQwCTT7lVyyaxf41NQhtH2v7IfsGp_5GdkuwDJ_hlUukfoZIRkuZ2HYjS_9wBQgWyzv7HoAoJtXblG-bIOnz6REKlV7NJenWEbp4QO1k48Qc2jhBEk-16T5qsiyvWrB-fODEkycousv1ee5GE7Yi66OOn-u04d7cS5Nmfu67bLYt3D-vgV_TWgMTvfNhz9MqU7VSQRW5m9UsYTlgRfKUPgEkUSpple_WhXfOVs7YH7ROpBQa362cJdyrPFDKI4Bg
        Jwt jwt = JwtHelper.decode(token);
        String claims = jwt.getClaims();
        JSONObject jsonObject = JSON.parseObject(claims);
        String userId = jsonObject.getString("user_name");
        String userDetail = jsonObject.getString("user_info");
        List<String> roleNames = (List<String>) jsonObject.get("authorities");
        return "Say hello to "+ userId + ", role:  " + roleNames.toString() +" details: "+ userDetail;
    }
}
