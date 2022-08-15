package com.example.controller;

import com.example.po.*;
import com.example.service.*;
import com.example.vo.DataVo;
import com.example.vo.RelationVo;
import com.example.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.relation.RelationService;
import java.util.LinkedList;
import java.util.List;


/**
 * @program: demo1
 * @description: 通用的控制层
 * @author: stop.yc
 * @create: 2022-08-13 15:03
 **/
@RestController
@RequestMapping(value = "/common",produces = "application/json;charset=UTF-8")
public class CommonController {

    @Autowired
    private KeyWordService keyWordService;

    @Autowired
    private PaperService paperService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private RootService rootService;

    @Autowired
    private KeyWordRelationService keyWordRelationService;

    @Autowired
    private TeamRelationService teamRelationService;

    @Autowired
    private CitationRelationService citationRelationService;

    @Autowired
    private PublishRelationService publishRelationService;

    @Autowired
    private PaperRelationService paperRelationService;


    @GetMapping
    public Result getAll() {
        Iterable<KeyWord> keyWords = keyWordService.getAll();
        Iterable<Root> roots = rootService.getAll();
        Iterable<Team> teams = teamService.getAll();
        Iterable<Paper> papers = paperService.getAll();
        List<RelationVo> keyWordRelations = transferStyle(keyWordRelationService.getAll());
        List<RelationVo> teamRelations = transferStyle(teamRelationService.getAll());
        List<RelationVo> citationRelations = transferStyle(citationRelationService.getAll());
        List<RelationVo> publishRelations = transferStyle(publishRelationService.getAll());
        List<RelationVo> paperRelations = transferStyle(paperRelationService.getAll());

        return new Result(new DataVo(roots,teams,keyWords,papers,keyWordRelations,publishRelations,teamRelations,citationRelations,paperRelations));
    }



    private List<RelationVo> transferStyle(Iterable<? extends Relation> relations) {

        List<RelationVo> relationVos = new LinkedList<>();
        RelationVo relationVo = null;
        for (Relation relation : relations) {
            relationVo = new RelationVo();
            relationVo.setSrcId(relation.getSrc().getId());
            relationVo.setDestId(relation.getDest().getId());
            relationVos.add(relationVo);
        }
        return relationVos;
    }
}
