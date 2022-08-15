package com.example.service;


import com.example.po.CitationRelation;
import com.example.po.KeyWordRelation;

/**
 * @program: knowledge_mapping
 * @description: 关键字业务层
 * @author: stop.yc
 * @create: 2022-08-12 20:37
 **/
public interface CitationRelationService {




    /**
     * 查询所有的关键字
     * @return :关键字集合结果集
     */
    Iterable<CitationRelation> getAll();


}
