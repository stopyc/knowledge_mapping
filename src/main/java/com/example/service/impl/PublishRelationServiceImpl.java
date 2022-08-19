package com.example.service.impl;

import com.example.dao.bak.PublishRelationRepository;
import com.example.po.PublishRelation;
import com.example.service.PublishRelationService;
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
public class PublishRelationServiceImpl implements PublishRelationService {



    @Autowired
    private PublishRelationRepository publishRelationRepository;

    @Override
    public Iterable<PublishRelation>  getAll() {
        return publishRelationRepository.findAll(1);
    }

}
