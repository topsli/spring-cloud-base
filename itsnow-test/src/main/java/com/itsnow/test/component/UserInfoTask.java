package com.itsnow.test.component;


import com.itsnow.test.client.OperationDataService;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

/**
 * Created by Xuekun_Li on 2018/7/26.
 */

public class UserInfoTask {

    private RestTemplate restTemplate;

//    BaseUserService baseUserService;

//    SuperClassService superClassService;

     OperationDataService operationDataService;

//    public UserInfoTask(RestTemplate restTemplate, TaskScheduler scheduler) {
//        this.restTemplate = restTemplate;
//        scheduler.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    syncUser();
//                } catch (Exception e) {
//                    System.out.println(e);
//                }
//            }
//        }, DateUtils.addSeconds(new Date(), 60), 120000);
//    }

//    public UserInfoTask(BaseUserService baseUserService, TaskScheduler scheduler) {
//        this.baseUserService = baseUserService;
//        scheduler.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    syncUser();
//                } catch (Exception e) {
//                    System.out.println(e);
//                }
//            }
//        }, DateUtils.addSeconds(new Date(), 10), 120000);
//    }


        public UserInfoTask(OperationDataService operationDataService, TaskScheduler scheduler) {
        this.operationDataService = operationDataService;
        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    syncUser();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }, DateUtils.addSeconds(new Date(), 10), 12000);
    }

// // http://main-data/user/name/itsnow
    private void syncUser() {
        //Object obj = restTemplate.getForObject("http://OPERATION/operation/api/cmdb/metadata/superClass/MC_SSHPassword",Object.class);

        Object obj = operationDataService.findUserName("MC_SSHPassword");


        System.out.println("====call syncUser method:"+obj.toString());
    }
}
