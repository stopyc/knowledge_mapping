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
     * 通过关键字id获取关键字对象
     * @param id :关键字id
     * @return :返回封装了关键字的结果集
     */
    @GetMapping("/{id}")
    Result getInfoById(@PathVariable Long id) {

        return keyWordService.getInfoById(id);
    }


    @GetMapping
    Result getAll() {
        return keyWordService.getAll();
    }
}
