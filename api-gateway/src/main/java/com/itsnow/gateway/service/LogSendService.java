package com.itsnow.gateway.service;

import com.netflix.zuul.context.RequestContext;

/**
 * Created by Xuekun_Li on 2018/6/26.
 */
public interface LogSendService {

    /**
     * 往消息通道发消息
     * @param requestContext
     */
    void send(RequestContext requestContext);
}
