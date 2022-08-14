package com.example.vo;

import com.example.po.node.KeyWord;
import com.example.po.node.Paper;
import com.example.po.node.Root;
import com.example.po.node.Team;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @program: demo1
 * @description: 数据类vo
 * @author: stop.yc
 * @create: 2022-08-14 10:17
 **/
@Data
@AllArgsConstructor
@ToString
public class DataVo {
    private Iterable<Root> roots;
    private Iterable<Team> teams;
    private Iterable<KeyWord> keyWords;
    private Iterable<Paper> papers;


    public DataVo(Iterable<Root> roots, Iterable<Team> teams, Iterable<KeyWord> keyWords) {
        this.roots = roots;
        this.teams = teams;
        this.keyWords = keyWords;
    }

    public DataVo(Iterable<Paper> papers) {
        this.papers = papers;
    }
}