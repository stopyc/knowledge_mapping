package com.example.controller;

import com.example.service.KeyWordService;
import com.example.service.RootService;
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
@RequestMapping(value = "/roots",produces = "application/json;charset=UTF-8")
public class RootController {
    @Resource
    private RootService rootService;


    @GetMapping
    Result getAll() {
        return rootService.getAll();
    }
}
