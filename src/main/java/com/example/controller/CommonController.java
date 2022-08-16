package com.example.controller;

import com.example.dao.CommonRepository;
import com.example.po.*;
import com.example.service.*;
import com.example.vo.DataVo;
import com.example.vo.RelationVo;
import com.example.vo.Result;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import jdk.nashorn.internal.ir.CallNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.relation.RelationService;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 通用控制层
 * @author YC104
 */
@RestController
@RequestMapping(value = "/common", produces = "application/json;charset=UTF-8")
public class CommonController {

    @Autowired
    private KeyWordService keyWordService;

    @Autowired
    private PaperService paperService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private RootService rootService;

    @Autowired
    private KeyWordRelationService keyWordRelationService;

    @Autowired
    private TeamRelationService teamRelationService;

    @Autowired
    private CitationRelationService citationRelationService;

    @Autowired
    private PublishRelationService publishRelationService;

    @Autowired
    private PaperRelationService paperRelationService;

    @Autowired
    private CommonService commonService;


    static CountDownLatch countDownLatch = new CountDownLatch(7);


    /**
     * 获取所有节点和边的数据
     * @return :封装了节点和边数据的及国际
     * @throws InterruptedException :计数器wait异常
     */
    @GetMapping
    public Result getAll() throws InterruptedException {

        //老版,直接在一个线程里进行查询,效率较低
//        Iterable<KeyWord> keyWords = keyWordService.getAll();
//        Iterable<Root> roots = rootService.getAll();
//        Iterable<Team> teams = teamService.getAll();
//        Iterable<Paper> papers = paperService.getAll();
//        List<RelationVo> keyWordRelations = transferStyle(keyWordRelationService.getAll());
//        List<RelationVo> teamRelations = transferStyle(teamRelationService.getAll());
//        List<RelationVo> citationRelations = transferStyle(citationRelationService.getAll());
//        List<RelationVo> publishRelations = transferStyle(publishRelationService.getAll());
//        List<RelationVo> paperRelations = transferStyle(paperRelationService.getAll());
//
//        return new Result(new DataVo(roots,teams,keyWords,papers,keyWordRelations,publishRelations,teamRelations,citationRelations,paperRelations));


        //优化,使用多线程进行异步查询,并同时全部结束返回
        EventLoopGroup group = new NioEventLoopGroup(7);

        final Iterable<KeyWord>[] keyWords = new Iterable[1];
        Iterable<Root> roots = rootService.getAll();
        final Iterable<Team>[] teams = new Iterable[1];

        final List<RelationVo>[] keyWordRelations = new List[1];
        final List<RelationVo>[] teamRelations = new List[1];
        final List<RelationVo>[] citationRelations = new List[1];
        final List<RelationVo>[] publishRelations = new List[1];
        final List<RelationVo>[] paperRelations = new List[1];



        group.next().submit(() -> {
            keyWords[0] = keyWordService.getAll();
            countDownLatch.countDown();
        });


        group.next().submit(() -> {
            teams[0] = teamService.getAll();
            countDownLatch.countDown();
        });
        group.next().submit(() -> {
            keyWordRelations[0] = transferStyle(keyWordRelationService.getAll());
            countDownLatch.countDown();
        });

        group.next().submit(() -> {
            teamRelations[0] = transferStyle(teamRelationService.getAll());
            countDownLatch.countDown();
        });

        group.next().submit(() -> {
            citationRelations[0] = transferStyle(citationRelationService.getAll());
            countDownLatch.countDown();
        });

        group.next().submit(() -> {
            publishRelations[0] = transferStyle(publishRelationService.getAll());
            countDownLatch.countDown();
        });

        group.next().submit(() -> {
            paperRelations[0] = transferStyle(paperRelationService.getAll());
            countDownLatch.countDown();
        });

        Iterable<Paper> papers = paperService.getAll();

        countDownLatch.await();
        countDownLatch = new CountDownLatch(7);

        return new Result(new DataVo(roots, teams[0], keyWords[0], papers, keyWordRelations[0], publishRelations[0], teamRelations[0], citationRelations[0], paperRelations[0]));


        //往后优化思路,因为接口几乎是一模一样的,建议处理为反射或者泛型,自动判断类型调用方法,然后建议把查的数据放在redis缓存里面,就不用直接来到数据库查了
    }


    private List<RelationVo> transferStyle(Iterable<? extends Relation> relations) {


        //1.如果查的数据为空
        if (null == relations || !relations.iterator().hasNext()) {
            return null;
        }

        //2.需要进行全部进行vo转换,前端需要,srcId,destId,label(名称)
        List<RelationVo> relationVos = new LinkedList<>();
        RelationVo relationVo = null;

        //3.获取迭代器第一个的字节码对象,获取类上的注解,里面包含着label
        RelationshipEntity annotation = relations.iterator().next().getClass().getAnnotation(RelationshipEntity.class);
        String label = annotation.value();

        //4.遍历封装
        for (Relation relation : relations) {
            relationVo = new RelationVo();
            relationVo.setSrcId(relation.getSrc().getId());
            relationVo.setLabel(label);
            relationVo.setDestId(relation.getDest().getId());
            relationVos.add(relationVo);
        }
        return relationVos;
    }


    /**
     * 通过id获取结点信息
     * @param id :结点id
     * @return :返回一个封装了节点信息的结果集
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Long id) {
        Node nodeById = commonService.getNodeById(id);

        return new Result(nodeById);
    }


}
