package com.example.service.impl;

import com.example.dao.KeyWordRelationshipRepository;
import com.example.dao.KeyWordRepository;
import com.example.service.KeyWordRelationshipService;
import com.example.service.KeyWordService;
import com.example.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: knowledge_mapping
 * @description: 关键字业务层实现类
 * @author: stop.yc
 * @create: 2022-08-12 20:40
 **/
@Service
@Transactional
public class KeyWordRelationshipServiceImpl implements KeyWordRelationshipService {



    @Autowired
    private KeyWordRelationshipRepository keyWordRelationshipRepository;


    @Override
    public Result getAll() {
        return new Result(keyWordRelationshipRepository.getAllData());
    }

}
