package com.example.po.relationship;

import com.example.po.node.KeyWord;
import com.example.po.node.Paper;
import lombok.Data;
import org.neo4j.ogm.annotation.*;

/**
 * @program: demo1
 * @description: 关键词关系
 * @author: stop.yc
 * @create: 2022-08-13 16:53
 **/
@Data
@RelationshipEntity("keywordRelationship")
public class KeyWordRelationship {


    @Property("name")
    private String name;

    @StartNode
    private Paper paper;

    @EndNode
    private KeyWord keyWord;
}
