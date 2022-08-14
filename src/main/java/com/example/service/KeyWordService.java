package com.example.service;


import com.example.po.KeyWord;
import com.example.po.Team;
import com.example.vo.Result;
import com.sun.org.apache.xpath.internal.compiler.Keywords;

import javax.print.DocFlavor;

/**
 * @program: knowledge_mapping
 * @description: 关键字业务层
 * @author: stop.yc
 * @create: 2022-08-12 20:37
 **/
public interface KeyWordService {




    /**
     * 查询所有的关键字
     * @return :关键字集合结果集
     */
    Iterable<KeyWord> getAll();


}
