package com.example.po.node;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.*;

import java.io.Serializable;
import java.util.Date;
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
public class Paper implements Serializable {

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
    private String title;


    @Relationship(type = "引用")
    @JsonProperty("r_citation")
    private List<Paper> papers;

    @Relationship(type = "关键词")
    @JsonProperty("r_keyword")
    private List<KeyWord> keyWords;

}
