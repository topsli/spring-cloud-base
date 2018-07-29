package com.itsnow.test.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Xuekun_Li on 2018/7/27.
 */

@FeignClient(name="itsnow-service" )
public interface OperationDataService {

    @RequestMapping(value = "/user/name/{userName}", method = RequestMethod.GET)
    Object findUserName(@PathVariable("userName") String userName);

}
