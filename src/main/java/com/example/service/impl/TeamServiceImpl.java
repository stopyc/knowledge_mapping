package com.example.service.impl;

import com.example.dao.RootRepository;
import com.example.dao.TeamRepository;
import com.example.po.Team;
import com.example.service.RootService;
import com.example.service.TeamService;
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
public class TeamServiceImpl implements TeamService {



    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Iterable<Team>  getAll() {
        return teamRepository.findAll(0);
    }

}
