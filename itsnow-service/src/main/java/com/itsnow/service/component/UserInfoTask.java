package com.itsnow.service.component;

//import com.itsnow.service.service.OperationDataService;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

/**
 * Created by Xuekun_Li on 2018/7/26.
 */

public class UserInfoTask {

    private RestTemplate restTemplate;

    public UserInfoTask(RestTemplate restTemplate, TaskScheduler scheduler) {
        this.restTemplate = restTemplate;
        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                   // syncUser();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }, DateUtils.addSeconds(new Date(), 10), 12000);
    }

    Object obj1 = "{'pageSize':10,'pageNum':1}";

    private void syncUser() {
        Object obj = restTemplate.postForObject("http://PASSPORT-MANAGEMENT123/passport-management/api/v1/role/list",obj1,Object.class);
        System.out.println("====call syncUser method:"+obj.toString());
    }
}
