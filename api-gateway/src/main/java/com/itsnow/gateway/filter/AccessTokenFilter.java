package com.itsnow.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Xuekun_Li on 2018/7/29.
 */
public class AccessTokenFilter extends ZuulFilter {

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        System.out.println(String.format("%s AccessTokenFilter request to %s", request.getMethod(),
                request.getRequestURL().toString()));

        ctx.setSendZuulResponse(true);
        ctx.setResponseStatusCode(200);
        ctx.setResponseBody("{\"name\":\"chhliu\"}");// 输出最终结果
        return null;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public String filterType() {
        return "post";// 在请求被处理之后，会进入该过滤器
    }
}
