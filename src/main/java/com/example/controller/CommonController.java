package com.example.controller;

import com.example.service.CommonService;
import com.example.vo.DataVo;
import com.example.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;

/**
 * @program: demo1
 * @description: 通用的控制层
 * @author: stop.yc
 * @create: 2022-08-13 15:03
 **/
@RestController
@RequestMapping(value = "/common",produces = "application/json;charset=UTF-8")
public class CommonController {

    @Autowired
    CommonService commonService;

    @GetMapping
    Result getAllData() {
        Result allData = commonService.getAllData();

        Result otherData = commonService.getOtherData();

        DataVo data = (DataVo) otherData.getData();

        DataVo data2 = (DataVo) allData.getData();
        return new Result(new DataVo(data.getRoots(),data.getTeams(),data.getKeyWords(),data2.getPapers()));
    }
}
