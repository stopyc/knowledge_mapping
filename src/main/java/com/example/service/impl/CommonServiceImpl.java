package com.example.service.impl;

import com.example.dao.KeyWordRepository;
import com.example.dao.PaperRepository;
import com.example.dao.RootRepository;
import com.example.dao.TeamRepository;
import com.example.po.node.KeyWord;
import com.example.po.node.Paper;
import com.example.po.node.Root;
import com.example.po.node.Team;
import com.example.service.CommonService;
import com.example.service.KeyWordService;
import com.example.vo.DataVo;
import com.example.vo.Result;
import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: knowledge_mapping
 * @description: 关键字业务层实现类
 * @author: stop.yc
 * @create: 2022-08-12 20:40
 **/
@Service
@Transactional
public class CommonServiceImpl implements CommonService {

    @Autowired
    private RootRepository rootDao;
    @Autowired
    private KeyWordRepository keyWordDao;
    @Autowired
    private PaperRepository paperDao;
    @Autowired
    private TeamRepository teamDao;

    @Autowired
    private BeanFactory beanFactory;


    @Override
    public Result getAllData() {

        //从root开始查,root - 团队 -> team

        Iterable<Paper> papers = paperDao.findAll(1);
        System.out.println("papers = " + papers);

//        Iterable<Root> roots = rootDao.findAll();
//        System.out.println("roots = " + roots);
//


/*        List<Team> teams = new ArrayList<>();
        List<Paper> papers = new ArrayList<>();
        List<KeyWord> keyWords = new ArrayList<>();
        //现在每一个根里面都放着很多个团队,里面团队的发表关系为空,现在需要给他们补上

        for (Root root : roots) {
            //对root里面的团队进行查询,
            //现在拿到了一个团队的集合

            if (root.getTeams() == null) {
                continue;
            }
            teams = root.getTeams();

            //遍历每一个团队,找出他们的下面的发表的论文
            for (Team team : teams) {
                team =  teamDao.findAllById(team.getId());

                //现在已经拿到了团队发表的所有论文集合
                //现在需要遍历每一个论文,查询他引用了什么论文,和拥有哪些关键字
                if (team.getPapers() == null) {
                    continue;
                }

                papers = team.getPapers();

                for (Paper paper : papers) {
                    paper = paperDao.findById(paper.getId()).get();

                    //现在已经拿到了所有论文,里面包含了引用和关键词
                    //现在需要对关键词进行查询存在哪些论文里面
                    keyWords = paper.getKeyWords();

                    if (keyWords == null) {
                        continue;
                    }
                    for (KeyWord keyWord : keyWords) {
                        keyWord = keyWordDao.findById(keyWord.getId()).get();
                    }
                }
            }
        }*/

//        Iterable<KeyWord> keywords = keyWordDao.findAll();
//        System.out.println("keywords = " + keywords);
////////
//
//        Iterable<Team> teams = teamDao.findAll();
//        System.out.println("teams = " + teams);

        return new Result(new DataVo(papers));
//        return new Result(new DataVo(roots,teams,keywords,papers));
    }

    @Override
    public Result getOtherData() {
        Iterable<Root> roots = rootDao.findAll(1);
        Iterable<KeyWord> keywords = keyWordDao.findAll(1);
        Iterable<Team> teams = teamDao.findAll(1);

        return new Result(new DataVo(roots,teams,keywords));

    }
}
