package com.itsnow.cmdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by Xuekun_Li on 2019/5/17.
 */
@ServletComponentScan
@SpringBootApplication
public class CmdbApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CmdbApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(CmdbApplication.class, args);
    }

}
