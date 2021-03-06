package com.itsnow.main.client;

import com.itsnow.common.pojo.ResponseData;
import com.itsnow.main.api.InterfaceService;
import com.itsnow.main.api.mapper.model.BaseRole;
import com.itsnow.main.api.pojo.ResponseCode;
import com.itsnow.main.api.service.BaseRoleRemoteService;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by Xuekun_Li on 2018/4/17.
 */
@FeignClient(name = InterfaceService.SERVICE_NAME, fallback = BaseRoleService.HystrixClientFallback.class)
public interface BaseRoleService extends BaseRoleRemoteService{

    class HystrixClientFallback implements BaseRoleService{

        @Override
        public ResponseData<List<BaseRole>> getRoleByUserId(@PathVariable("userId") String userId) {
            return new ResponseData<>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getMessage());
        }
    }
}
