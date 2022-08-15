package com.example.controller;

import com.example.service.PaperService;
import com.example.service.TeamService;
import com.example.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 关键字控制层
 * @author YC104
 */
@RestController
@RequestMapping(value = "/papers",produces = "application/json;charset=UTF-8")
public class PaperController {
    @Resource
    private PaperService paperService;


    /**
     * 获取所有根结点
     * @return :返回封装了所有根结点的结果集
     */
    @GetMapping
    Result getAll() {
        return new Result(paperService.getAll());
    }
}
