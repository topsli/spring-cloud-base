//package com.itsnow.service.controller;
//
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.jwt.Jwt;
//import org.springframework.security.jwt.JwtHelper;
//import org.springframework.security.oauth2.client.OAuth2RestTemplate;
//import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * Created by Xuekun_Li on 2018/4/9.
// */
//@RestController
//public class MyUserController  {
//
//
//    @Autowired
//    private OAuth2RestTemplate oAuth2RestTemplate;
//    /**
//     * 根据用户名获取用户信息
//     * @param userName
//     * @return
//     */
//    @RequestMapping(value = "/user/name/{userName}", method = RequestMethod.GET)
//    public  String getUserByUserName(@PathVariable("userName") String userName) {
////        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
////        String token =  "Bearer " + details.getTokenValue();
//        MultiValueMap<String, Object> postParameters = new LinkedMultiValueMap<>();
//        postParameters.add("username", "itsnow");
//        postParameters.add("password", "111111");
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Type", "application/x-www-form-urlencoded");
//        //headers.add("Authorization", token);
//        HttpEntity<MultiValueMap<String, Object>> map = new HttpEntity<>(postParameters, headers);
//
//
//        Object result = oAuth2RestTemplate.postForObject("http://localhost:18001/auth/api/v1/login",  map, String.class);
//        return "the final userName is:"+result.toString();
//    }
//
//
//    @RequestMapping(value = "/user/currentUser",method = RequestMethod.GET)
//    public String currentUserInfo(){
//        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
//        String token =  details.getTokenValue();
//        Jwt jwt = JwtHelper.decode(token);
//        String claims = jwt.getClaims();
//        JSONObject jsonObject = JSON.parseObject(claims);
//        String userId = jsonObject.getString("user_name");
//        String userDetail = jsonObject.getString("user_info");
//        List<String> roleNames = (List<String>) jsonObject.get("authorities");
//        return "Say hello to "+ userId + ", role:  " + roleNames.toString() +" details: "+ userDetail;
//    }
//
//
//}
