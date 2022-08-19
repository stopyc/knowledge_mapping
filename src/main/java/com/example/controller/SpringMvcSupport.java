package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @program: knowledge_mapping
 * @description:
 * @author: stop.yc
 * @create: 2022-08-17 19:53
 **/
//@Configuration
//@ComponentScan({"com.qgstudio.interceptor","com.qgstudio.config"})
//public class SpringMvcSupport extends WebMvcConfigurationSupport {
//
//    @Autowired
//    private MonitorInterceptor monitorInterceptor;
//    @Autowired
//    private MonitorConfig monitorConfig;
//
//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//        //配置拦截器,要监控的接口
//        registry.addInterceptor(monitorInterceptor).addPathPatterns(monitorConfig.getPathPatterns());
//    }
//}
