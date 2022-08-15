package com.example.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.*;

/**
 * @program: knowledge_mapping
 * @description: 关键词关系
 * @author: stop.yc
 * @create: 2022-08-15 09:29
 **/
@RelationshipEntity("论文")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaperRelation implements Relation{

    @Id
    @GeneratedValue
    private Long id;


    @StartNode
    private KeyWord src;

    @EndNode
    private Paper dest;

}
