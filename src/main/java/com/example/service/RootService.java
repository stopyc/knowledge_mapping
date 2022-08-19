package com.example.service;


import com.example.po.Root;
import com.example.po.Team;
import com.example.vo.Result;

/**
 * @program: knowledge_mapping
 * @description: 关键字业务层
 * @author: stop.yc
 * @create: 2022-08-12 20:37
 **/
public interface RootService{







    /**
     * 查询所有的关键字
     * @return :关键字集合结果集
     */
    Iterable<Root> getAll();


}
