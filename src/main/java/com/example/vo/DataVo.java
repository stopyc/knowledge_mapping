package com.example.vo;

import com.example.po.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Iterator;
import java.util.List;

/**
 * @program: demo1
 * @description: 数据类vo
 * @author: stop.yc
 * @create: 2022-08-14 10:17
 **/
@Data
@AllArgsConstructor
@ToString
public class DataVo {
//    private Iterable<Root> roots;
//    private Iterable<Team> teams;
//    private Iterable<KeyWord> keyWords;
//    private Iterable<Paper> papers;
//
//    @JsonProperty("r_keyword")
//    private Iterable<RelationVo> keyWordRelations;
//
//    @JsonProperty("r_publish")
//    private Iterable<RelationVo> publishRelations;
//
//    @JsonProperty("r_team")
//    private Iterable<RelationVo> teamRelations;
//
//    @JsonProperty("r_citation")
//    private Iterable<RelationVo> citationRelations;
//
//    @JsonProperty("t_paper")
//    private Iterable<RelationVo> paperRelations;



    private List<NodeVo> nodes;


    @JsonProperty("edges")
    private List<RelationVo> relationVos;

}