package com.itsnow.auth.provider.config.web;

import com.itsnow.auth.api.model.OauthClientDetails;
import com.itsnow.auth.api.pojo.ResponseCode;


import com.itsnow.auth.provider.service.OauthClientDetailsService;
import com.itsnow.common.pojo.ResponseData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Xuekun_Li on 2018/5/15.
 */
@Controller
@SessionAttributes({"authorizationRequest"})
public class MvcController {

//    @Autowired
//    private BaseClientService baseClientService;

    @Autowired
    private OauthClientDetailsService oauthClientDetailsService;
    /**
     * 登出回调
     * @param request
     * @param response
     */
    @RequestMapping("/backReferer")
    public void sendBack(HttpServletRequest request, HttpServletResponse response) {

        try {
            //sending back to client app
            String referer = request.getHeader("referer");
            if (referer != null) {
                int index = referer.indexOf("?");
                if(index != -1)
                    referer = referer.substring(0, index);
                response.sendRedirect(referer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 授权页面
     * @param model
     * @return
     */
    @RequestMapping("/oauth/confirm_access")
    public ModelAndView authorizePage(Map<String, Object> model) {
        // 获取用户名
        String userName = ((UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal())
                .getUsername();
        model.put("userName", userName);
        return new ModelAndView("authorize", model);
    }

    /**
     * 主页，未从客户端跳转直接登陆会显示
     * @param model
     * @return
     */
    @RequestMapping("/")
    public ModelAndView indexPage(Map<String, Object> model) {
        // 获取用户名
        String userName = ((UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal())
                .getUsername();
        model.put("userName", userName);
        // 获取全部客户端应用
        List<OauthClientDetails> list = oauthClientDetailsService.selectAll();
        if(list != null) {
            model.put("client",list);
        } else {
            model.put("client",new ArrayList<>());
        }
        return new ModelAndView("index", model);
    }
}
