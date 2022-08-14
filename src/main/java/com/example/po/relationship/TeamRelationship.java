package com.example.po.relationship;

import com.example.po.node.KeyWord;
import com.example.po.node.Paper;
import com.example.po.node.Root;
import com.example.po.node.Team;
import lombok.Data;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

/**
 * @program: demo1
 * @description: 关键词关系
 * @author: stop.yc
 * @create: 2022-08-13 16:53
 **/
@Data
@RelationshipEntity("teamRelationship")
public class TeamRelationship {


    @Property("name")
    private String name;

    @StartNode
    private Root root;

    @EndNode
    private Team team;
}
