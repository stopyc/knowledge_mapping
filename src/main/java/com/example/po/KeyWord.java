package com.example.po;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * @program: knowledge_mapping
 * @description: 关键字
 * @author: stop.yc
 * @create: 2022-08-12 20:33
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@NodeEntity("keyword")
public class KeyWord implements Node{

    @Id
    @GeneratedValue
    private Long id;


    @Property("name")
    private String label;

}
