package com.itsnow.main.provider.service;

import com.itsnow.db.spring.boot.autoconfigure.service.BaseService;
import com.itsnow.main.api.mapper.model.BaseSystem;
import com.itsnow.main.api.pojo.response.ModuleAndSystemResponse;
import com.itsnow.main.provider.mapper.mapper.BaseSystemMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Xuekun_Li on 2018/4/9.
 */
@Service
public class BaseSystemService extends BaseService<BaseSystem>{
    public List<ModuleAndSystemResponse> selectModuleAndSystem() {
        return ((BaseSystemMapper)mapper).selectModuleAndSystem();
    }
}
