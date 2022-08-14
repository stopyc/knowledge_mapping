package com.example.service.impl;

import com.example.dao.KeyWordRepository;
import com.example.service.KeyWordService;
import com.example.vo.Result;
import org.neo4j.ogm.model.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Key;

/**
 * @program: knowledge_mapping
 * @description: 关键字业务层实现类
 * @author: stop.yc
 * @create: 2022-08-12 20:40
 **/
@Service
@Transactional
public class KeyWordServiceImpl implements KeyWordService {



    @Autowired
    private  KeyWordRepository keyWordRepository;

    @Override
    public Result getInfoById(Long id) {
        return new Result(keyWordRepository.findById(id).get());
    }

    @Override
    public Result getAll() {
        return new Result(keyWordRepository.findAll());
    }

}
