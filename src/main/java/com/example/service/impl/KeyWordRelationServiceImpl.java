package com.example.service.impl;

import com.example.dao.KeyWordRelationRepository;
import com.example.dao.KeyWordRepository;
import com.example.dao.TeamRepository;
import com.example.po.KeyWordRelation;
import com.example.po.Team;
import com.example.service.KeyWordRelationService;
import com.example.service.TeamService;
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
public class KeyWordRelationServiceImpl implements KeyWordRelationService {



    @Autowired
    private KeyWordRelationRepository keyWordRelationRepository;

    @Override
    public Iterable<KeyWordRelation>  getAll() {
        return keyWordRelationRepository.findAll(1);
    }

}
