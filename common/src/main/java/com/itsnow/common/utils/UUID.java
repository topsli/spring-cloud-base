package com.itsnow.common.utils;

/**
 * Created by Xuekun_Li on 2018/5/12.
 */
public class UUID {

    public static String uuid32 () {
        return java.util.UUID.randomUUID().toString().replace("-", "");
    }
}
