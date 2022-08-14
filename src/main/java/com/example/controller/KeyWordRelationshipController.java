package com.example.controller;

import com.example.service.KeyWordRelationshipService;
import com.example.service.KeyWordService;
import com.example.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 关键字控制层
 * @author YC104
 */
@RestController
@RequestMapping(value = "/keywordRelationship",produces = "application/json;charset=UTF-8")
public class KeyWordRelationshipController {
    @Resource
    private KeyWordRelationshipService keyWordRelationshipService;


    @GetMapping
    Result getAll() {
        return keyWordRelationshipService.getAll();
    }
}
