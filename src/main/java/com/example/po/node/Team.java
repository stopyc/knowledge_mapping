package com.example.po.node;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.io.Serializable;
import java.util.List;

/**
 * @program: demo1
 * @description: 团队
 * @author: stop.yc
 * @create: 2022-08-13 16:44
 **/

@Data
@NodeEntity("team")
@AllArgsConstructor
@NoArgsConstructor
public class Team implements Serializable {

    @Id
    private Long id;


    @Property("branch")
    private String branch;


    @Property("expert")
    private String expert;


    @Property("team")
    private String team;

    @Relationship(type = "发表")
    @JsonProperty("r_publish")
    private List<Paper> papers;
}
