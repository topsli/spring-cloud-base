package com.itsnow.cmdb.util;

import java.util.IdentityHashMap;
import java.util.Map;

/**
 * Created by Xuekun_Li on 2019/5/17.
 */
public class UniqueObjectIdHolder {
    private static Map<Object, Integer> map = new IdentityHashMap<>();
    private static int count =0;

    public static int getId(Object object){
        if (!map.containsKey(object)){
            count++;
            map.put(object,count);
        }
        return map.get(object);
    }
}
