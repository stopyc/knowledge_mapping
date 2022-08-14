package com.example.controller;

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
@RequestMapping(value = "/keywords",produces = "application/json;charset=UTF-8")
public class KeyWordController {
    @Resource
    private KeyWordService keyWordService;

    /**
     * 获取所有关键字结点
     * @return :返回封装了所有关键字的结点
     */
    @GetMapping
    Result getAll() {
        return new Result(keyWordService.getAll());
    }
}
