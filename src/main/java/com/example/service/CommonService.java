package com.example.service;


import com.example.vo.Result;

/**
 * @program: knowledge_mapping
 * @description: 关键字业务层
 * @author: stop.yc
 * @create: 2022-08-12 20:37
 **/
public interface CommonService {
    /**
     * 获取所有的相关数据
     * @return :返回结果集
     */
    Result getAllData();

    Result getOtherData();



}
