package com.itsnow.main.api.service;

import com.itsnow.common.pojo.ResponseData;
import com.itsnow.main.api.mapper.model.OauthClientDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Xuekun_Li on 2018/5/18.
 */
public interface BaseClientRemoteService {

    @RequestMapping(value = "/client/all", method = RequestMethod.GET)
    ResponseData<List<OauthClientDetails>> getAllClient();

}
