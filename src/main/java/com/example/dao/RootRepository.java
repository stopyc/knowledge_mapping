package com.example.dao;

import com.example.po.node.KeyWord;
import com.example.po.node.Root;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * @program: knowledge_mapping
 * @description: 关键字dao层
 * @author: stop.yc
 * @create: 2022-08-12 21:10
 **/
@Repository
public interface RootRepository extends Neo4jRepository<Root,Long> {
}
