package com.example.controller;

import com.example.po.KeyWord;
import com.example.po.Paper;
import com.example.po.Root;
import com.example.po.Team;
import com.example.service.*;
import com.example.vo.DataVo;
import com.example.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
    private KeyWordService keyWordService;

    @Autowired
    private PaperService paperService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private RootService rootService;

//    /**
//     * 获取所有的数据
//     * @return :返回封装了所有结果的结果集
//     */
//    @GetMapping
//    public Result getAllData() {
//        Result allData = commonService.getAllData();
//
//        Result otherData = commonService.getOtherData();
//
//        DataVo data = (DataVo) otherData.getData();
//
//        DataVo data2 = (DataVo) allData.getData();
//        return new Result(new DataVo(data.getRoots(),data.getTeams(),data.getKeyWords(),data2.getPapers()));
//    }


    @GetMapping("/all")
    public Result getAll() {
        Iterable<KeyWord> keyWords = keyWordService.getAll();
        Iterable<Root> roots = rootService.getAll();
        Iterable<Team> teams = teamService.getAll();
        Iterable<Paper> papers = paperService.getAll();

        return new Result(new DataVo(roots,teams,keyWords,papers));
    }
}
