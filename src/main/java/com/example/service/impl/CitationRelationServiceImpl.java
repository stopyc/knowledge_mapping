package com.example.service.impl;

import com.example.dao.CitationRelationRepository;
import com.example.dao.KeyWordRelationRepository;
import com.example.po.CitationRelation;
import com.example.po.KeyWordRelation;
import com.example.service.CitationRelationService;
import com.example.service.KeyWordRelationService;
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
public class CitationRelationServiceImpl implements CitationRelationService {



    @Autowired
    private CitationRelationRepository citationRelationRepository;

    @Override
    public Iterable<CitationRelation>  getAll() {
        return citationRelationRepository.findAll(1);
    }

}
