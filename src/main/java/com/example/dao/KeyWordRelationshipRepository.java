package com.example.dao;

import com.example.po.node.KeyWord;
import com.example.po.relationship.KeyWordRelationship;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: knowledge_mapping
 * @description: 关键字dao层
 * @author: stop.yc
 * @create: 2022-08-12 21:10
 **/
@Repository
public interface KeyWordRelationshipRepository extends Neo4jRepository<KeyWordRelationship,Long> {


    @Query("match p=()-[r:`关键词`]->() return p")
    List<KeyWordRelationship> getAllData ();
}
