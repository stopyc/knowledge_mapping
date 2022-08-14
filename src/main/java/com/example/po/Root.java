package com.example.po;

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
 * @description: 根源类
 * @author: stop.yc
 * @create: 2022-08-13 16:42
 **/
@Data
@NoArgsConstructor
@NodeEntity("root")
@AllArgsConstructor
public class Root implements Serializable {

    @Id
    private Long id;


    @Property("name")
    private String name;

    @Relationship(type = "团队")
    @JsonProperty("r_team")
    private List<Team> teams;
}
