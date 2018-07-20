package com.itsnow.main.client;

import com.itsnow.common.pojo.ResponseData;
import com.itsnow.main.api.InterfaceService;
import com.itsnow.main.api.mapper.model.OauthClientDetails;
import com.itsnow.main.api.pojo.ResponseCode;
import com.itsnow.main.api.service.BaseClientRemoteService;
import org.springframework.cloud.netflix.feign.FeignClient;

import java.util.List;

/**
 * Created by Xuekun_Li on 2018/4/9.
 */
@FeignClient(name = InterfaceService.SERVICE_NAME, fallback = BaseClientService.HystrixClientFallback.class)
public interface BaseClientService extends BaseClientRemoteService {

    class HystrixClientFallback implements BaseClientService {

        @Override
        public ResponseData<List<OauthClientDetails>> getAllClient() {
            return new ResponseData<>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getMessage());
        }
    }
}
