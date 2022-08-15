package com.example.service.impl;

import com.example.dao.CitationRelationRepository;
import com.example.dao.PaperRelationRepository;
import com.example.po.CitationRelation;
import com.example.po.PaperRelation;
import com.example.service.CitationRelationService;
import com.example.service.PaperRelationService;
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
public class PaperRelationServiceImpl implements PaperRelationService {



    @Autowired
    private PaperRelationRepository paperRelationRepository;

    @Override
    public Iterable<PaperRelation>  getAll() {
        return paperRelationRepository.findAll(1);
    }

}
