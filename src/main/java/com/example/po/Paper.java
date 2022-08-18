package com.example.po;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * @program: demo1
 * @description: 论文
 * @author: stop.yc
 * @create: 2022-08-13 16:38
 **/
@Data
@NodeEntity("paper")
@NoArgsConstructor
@AllArgsConstructor
public class Paper implements Node{

    @Id
    private Long id;

    @Property("author")
    private String author;

    @Property("date")
    private Long date;

    @Property("keyword")
    private String keyword;

    @Property("periodicals")
    private String periodicals;

    @Property("title")
    private String label;


}
