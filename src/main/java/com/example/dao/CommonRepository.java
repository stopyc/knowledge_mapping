package com.example.dao;

import com.example.po.KeyWord;
import com.example.po.Node;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonRepository extends Neo4jRepository<Node,Long> {


    @Query("MATCH (r) WHERE id(r) = $id RETURN r")
    Node findNodeById(Long id);



}
