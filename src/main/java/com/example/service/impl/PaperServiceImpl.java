package com.example.service.impl;

import com.example.dao.PaperRepository;
import com.example.po.Paper;
import com.example.service.PaperService;
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
public class PaperServiceImpl implements PaperService {



    @Autowired
    private PaperRepository paperRepository;

    @Override
    public Iterable<Paper> getAll() {
        return paperRepository.findAll(1);
    }

}
