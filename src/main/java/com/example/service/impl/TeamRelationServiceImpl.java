package com.example.service.impl;

import com.example.dao.bak.TeamRelationRepository;
import com.example.po.TeamRelation;
import com.example.service.TeamRelationService;
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
public class TeamRelationServiceImpl implements TeamRelationService {



    @Autowired
    private TeamRelationRepository teamRelationRepository;

    @Override
    public Iterable<TeamRelation>  getAll() {
        return teamRelationRepository.findAll(1);
    }

}
