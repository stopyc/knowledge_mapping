package com.example.service.impl;

import com.example.dao.CommonRepository;
import com.example.po.Node;
import com.example.service.CommonService;
import com.example.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: knowledge_mapping
 * @description:
 * @author: stop.yc
 * @create: 2022-08-16 10:33
 **/
@Service
@Transactional
public class CommonServiceImpl implements CommonService {



    @Autowired
    private CommonRepository commonRepository;

    @Override
    public Node getNodeById(Long id) {
        return commonRepository.findNodeById(id);

    }
}
