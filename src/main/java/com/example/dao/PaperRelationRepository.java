package com.example.dao;

import com.example.po.KeyWordRelation;
import com.example.po.PaperRelation;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * @program: knowledge_mapping
 * @description: 关键字dao层
 * @author: stop.yc
 * @create: 2022-08-12 21:10
 **/
@Repository
public interface PaperRelationRepository extends Neo4jRepository<PaperRelation,Long> {
}
