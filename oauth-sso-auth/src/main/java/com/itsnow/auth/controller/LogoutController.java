package com.itsnow.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Xuekun_Li on 2018/8/10.
 */
@Controller
public class LogoutController {

//    @Autowired
//    private TokenStore tokenStore;

    @RequestMapping("/exit")
    public void exit(HttpServletRequest request, HttpServletResponse response) {
        // token can be revoked here if needed
        // revokeToken(request);
        new SecurityContextLogoutHandler().logout(request, null, null);
        try {
            //sending back to client app
            response.sendRedirect(request.getHeader("referer"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private void revokeToken(HttpServletRequest request){
//        String authHeader = request.getHeader("Authorization");
//        if(authHeader != null) {
//            String tokenValue = authHeader.replace("Bearer", "").trim();
//            OAuth2AccessToken accessToken = tokenStore.readAccessToken(tokenValue);
//            tokenStore.removeAccessToken(accessToken);
//        }
//    }

//    @RequestMapping(value = "/oauth/revoke-token",method = RequestMethod.GET)
//    public  @ResponseBody ResponseEntity<HttpStatus> logout (HttpServletRequest request){
//        String authHeader = request.getHeader("Authorization");
//        if(authHeader != null){
//            try {
//                String tokenValue = authHeader.replace("Bearer", "").trim();
//                OAuth2AccessToken accessToken = tokenStore.readAccessToken(tokenValue);
//                tokenStore.removeAccessToken(accessToken);
//            }
//            catch (Exception e){
//                return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
//            }
//        }
//
//        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
//    }
}
