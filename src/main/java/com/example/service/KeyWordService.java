package com.example.service;


import com.example.vo.Result;

import javax.print.DocFlavor;

/**
 * @program: knowledge_mapping
 * @description: 关键字业务层
 * @author: stop.yc
 * @create: 2022-08-12 20:37
 **/
public interface KeyWordService {




    /**
     * 根据id查询对象
     * @param id :id
     * @return :返回一个关键字对象
     */
    Result getInfoById(Long id);


    /**
     * 查询所有的关键字
     * @return :关键字集合结果集
     */
    Result getAll();


}
