///*
// *    Copyright (c) 2018-2025, lengleng All rights reserved.
// *
// * Redistribution and use in source and binary forms, with or without
// * modification, are permitted provided that the following conditions are met:
// *
// * Redistributions of source code must retain the above copyright notice,
// * this list of conditions and the following disclaimer.
// * Redistributions in binary form must reproduce the above copyright
// * notice, this list of conditions and the following disclaimer in the
// * documentation and/or other materials provided with the distribution.
// * Neither the name of the pig4cloud.com developer nor the names of its
// * contributors may be used to endorse or promote products derived from
// * this software without specific prior written permission.
// * Author: lengleng (wangiegie@gmail.com)
// */
//
//package com.itsnow.service.util;
//
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import org.apache.commons.lang.StringUtils;
//import org.springframework.security.jwt.Jwt;
//import org.springframework.security.jwt.JwtHelper;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.List;
//
///**
// * 用户相关工具类
// */
//
//public class UserUtils {
//
//    private static final String KEY_USER = "user";
//
//    /**
//     * token请求头名称
//     */
//    private static final String REQ_HEADER = "Authorization";
//
//    /**
//     * token分割符
//     */
//    private static final String TOKEN_SPLIT = "Bearer ";
//
//    /**
//     * 根据请求heard中的token获取用户角色
//     *
//     * @param httpServletRequest request
//     * @return 角色名
//     */
//    public static List<String> getRole(HttpServletRequest httpServletRequest) {
//        String token = getToken(httpServletRequest);
//        Jwt jwt = JwtHelper.decode(token);
//        String claims = jwt.getClaims();
//        JSONObject jsonObject = JSON.parseObject(claims);
//        List<String> roleNames = (List<String>) jsonObject.get("authorities");
//        return roleNames;
//    }
//
//    /**
//     * 根据header中的token获取用户ID
//     *
//     * @param httpServletRequest
//     * @return 用户ID
//     */
//    public static Integer getUserId(HttpServletRequest httpServletRequest) {
//        String token = getToken(httpServletRequest);
//        Jwt jwt = JwtHelper.decode(token);
//        String claims = jwt.getClaims();
//        JSONObject jsonObject = JSON.parseObject(claims);
//        Integer userId = (Integer) jsonObject.get("userId");
//        return userId;
//    }
//    /**
//     * 获取请求中token
//     *
//     * @param httpServletRequest request
//     * @return token
//     */
//    public static String getToken(HttpServletRequest httpServletRequest) {
//        String authorization = httpServletRequest.getHeader(REQ_HEADER);
//        return StringUtils.substringAfter(authorization, TOKEN_SPLIT);
//    }
//
//
//}
