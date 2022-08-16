//package com.example.controller;
//
//import com.example.service.PublishRelationService;
//import com.example.service.TeamRelationService;
//import com.example.vo.Result;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import javax.management.relation.RelationService;
//
///**
// * 关键字控制层
// * @author YC104
// */
//@RestController
//@RequestMapping(value = "/publishesRelation",produces = "application/json;charset=UTF-8")
//public class PublishRelationController {
//    @Resource
//    private PublishRelationService publishRelationService;
//
//    /**
//     * 获取所有关键字结点
//     * @return :返回封装了所有关键字的结点
//     */
//    @GetMapping
//    Result getAll() {
//        return new Result(publishRelationService.getAll());
//    }
//}
