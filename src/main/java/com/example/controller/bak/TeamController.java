//package com.example.controller;
//
//import com.example.service.RootService;
//import com.example.service.TeamService;
//import com.example.vo.Result;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//
///**
// * 团队节点控制层
// * @author YC104
// */
//@RestController
//@RequestMapping(value = "/teams",produces = "application/json;charset=UTF-8")
//public class TeamController {
//    @Resource
//    private TeamService teamService;
//
//
//    /**
//     * 获取所有团队结点
//     * @return :返回封装了所有团队结点的结果集
//     */
//    @GetMapping
//    public Result getAll() {
//        return new Result(teamService.getAll());
//    }
//}
