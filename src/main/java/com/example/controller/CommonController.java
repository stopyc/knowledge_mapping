package com.example.controller;

import com.example.dao.CommonRepository;
import com.example.po.*;
import com.example.service.*;
import com.example.vo.DataVo;
import com.example.vo.NodeVo;
import com.example.vo.RelationVo;
import com.example.vo.Result;
import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.Future;
import jdk.nashorn.internal.ir.CallNode;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.awt.image.ImageWatched;

import javax.management.ListenerNotFoundException;
import javax.management.relation.RelationService;
import javax.xml.ws.Service;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

/**
 * 通用控制层
 * @author YC104
 */
@RestController
@RequestMapping(value = "/common", produces = "application/json;charset=UTF-8")
@CrossOrigin("http://localhost:3000")
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

    static EventLoopGroup group = new NioEventLoopGroup(8);

    static EventLoopGroup group1 = new NioEventLoopGroup(7);


    /**
     * 获取所有节点和边的数据
     *
     * @return :封装了节点和边数据的及国际
     * @throws InterruptedException :计数器wait异常
     */
    @GetMapping
    public Result getAll() throws InterruptedException {
        System.out.println("getAll");

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


        System.out.println();
        final Iterable<KeyWord>[] keyWords = new Iterable[1];
        final Iterable<Team>[] teams = new Iterable[1];

        final List<RelationVo>[] keyWordRelations = new List[1];
        final List<RelationVo>[] teamRelations = new List[1];
        final List<RelationVo>[] citationRelations = new List[1];
        final List<RelationVo>[] publishRelations = new List[1];
        final List<RelationVo>[] paperRelations = new List[1];


        List<NodeVo> nodes = new LinkedList<>();

        group1.next().submit(() -> {

            NodeVo nodeVo = null;
            keyWords[0] = keyWordService.getAll();

            for (KeyWord keyWord : keyWords[0]) {
                nodeVo = new NodeVo();
                nodeVo.setId(keyWord.getId() + "").setLabel(keyWord.getLabel()).setType(1);
                nodes.add(nodeVo);
            }

            countDownLatch.countDown();
        });


        group1.next().submit(() -> {
            NodeVo nodeVo = null;
            teams[0] = teamService.getAll();
            for (Team team : teams[0]) {
                nodeVo = new NodeVo();
                nodeVo.setId(team.getId() + "").setLabel(team.getLabel()).setType(2);
                nodes.add(nodeVo);
            }
            countDownLatch.countDown();
        });
        group1.next().submit(() -> {
            NodeVo nodeVo = null;
            keyWordRelations[0] = transferStyle(keyWordRelationService.getAll());
            countDownLatch.countDown();
        });

        group1.next().submit(() -> {
            teamRelations[0] = transferStyle(teamRelationService.getAll());
            countDownLatch.countDown();
        });

        group1.next().submit(() -> {
            citationRelations[0] = transferStyle(citationRelationService.getAll());
            countDownLatch.countDown();
        });

        group1.next().submit(() -> {
            publishRelations[0] = transferStyle(publishRelationService.getAll());
            countDownLatch.countDown();
        });

        group1.next().submit(() -> {
            paperRelations[0] = transferStyle(paperRelationService.getAll());
            countDownLatch.countDown();
        });

        Iterable<Paper> papers = paperService.getAll();
        NodeVo nodeVo = null;
        for (Paper paper : papers) {
            nodeVo = new NodeVo();
            nodeVo.setId(paper.getId() + "").setLabel(paper.getLabel()).setType(3);
            nodes.add(nodeVo);
        }
        Iterable<Root> roots = rootService.getAll();
        for (Root root : roots) {
            nodeVo = new NodeVo();
            nodeVo.setId(root.getId() + "").setLabel(root.getLabel()).setType(4);
            nodes.add(nodeVo);
        }


        countDownLatch.await();
        List<RelationVo> list = new LinkedList<>();
        list.addAll(keyWordRelations[0]);
        list.addAll(teamRelations[0]);
        list.addAll(citationRelations[0]);
        list.addAll(publishRelations[0]);
        list.addAll(paperRelations[0]);

        countDownLatch = new CountDownLatch(7);

//        return new Result(new DataVo(roots, teams[0], keyWords[0], papers, keyWordRelations[0], publishRelations[0], teamRelations[0], citationRelations[0], paperRelations[0]));

        return new Result(new DataVo(nodes, list));

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
            relationVo.setSource(relation.getSrc().getId() + "");
            relationVo.setLabel(label);
            relationVo.setTarget(relation.getDest().getId() + "");
            relationVos.add(relationVo);
        }
        return relationVos;
    }


    /**
     * 通过id获取结点信息
     *
     * @param id :结点id
     * @return :返回一个封装了节点信息的结果集
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Long id) {
        System.out.println("getById");
        Node nodeById = commonService.getNodeById(id);

        return new Result(nodeById);
    }




    @GetMapping("/new")
    public Result newGetAll() throws InterruptedException {
        System.out.println("1");

        List<NodeVo> nodeVos =new LinkedList<>();
//        List<NodeVo> teams =null;
//        List<NodeVo> papers =null;
//        List<NodeVo> roots =null;

        List<RelationVo> relationVos = new LinkedList<>();
//        List<RelationVo> teamRelations =null;
//        List<RelationVo> citationRelations =null;
//        List<RelationVo> publishRelations = null;
//        List<RelationVo> paperRelations = null;

        //1.准备EventLoop对象
//        EventLoopGroup group = new NioEventLoopGroup(8);

        Future<List<RelationVo>> keyWordRelationFuture = group.next().submit(() -> transferStyle(keyWordRelationService.getAll()));
        Future<List<RelationVo>> teamRelationFuture = group.next().submit(() -> transferStyle(teamRelationService.getAll()));
        Future<List<RelationVo>> citationRelationFuture = group.next().submit(() -> transferStyle(citationRelationService.getAll()));
        Future<List<RelationVo>> publishRelationFuture = group.next().submit(() -> transferStyle(publishRelationService.getAll()));
        Future<List<RelationVo>> paperRelationFuture = group.next().submit(() -> transferStyle(paperRelationService.getAll()));
        Future<List<NodeVo>> keyWordsFuture = group.next().submit(() -> transferNodeStyle(keyWordService.getAll()));
        Future<List<NodeVo>> teamFuture = group.next().submit(() -> transferNodeStyle(teamService.getAll()));
        Future<List<NodeVo>> paperFuture = group.next().submit(() -> transferNodeStyle(paperService.getAll()));


        try {
            nodeVos.addAll(transferNodeStyle(rootService.getAll()));
            relationVos.addAll(keyWordRelationFuture.get());
            relationVos.addAll(teamRelationFuture.get());
            relationVos.addAll(citationRelationFuture.get());
            relationVos.addAll(publishRelationFuture.get());
            nodeVos .addAll(keyWordsFuture.get());
            nodeVos .addAll(teamFuture.get());
            relationVos.addAll(paperRelationFuture.get());
            nodeVos .addAll(paperFuture.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        return new Result(new DataVo(nodeVos,relationVos));
    }

    private List<NodeVo> transferNodeStyle(Iterable<? extends Node> nodes) {

        //1.如果查的数据为空
        if (null == nodes || !nodes.iterator().hasNext()) {
            return null;
        }

        //2.需要进行全部进行vo转换,前端需要,id,label(名称),type(类型:
        List<RelationVo> relationVos = new LinkedList<>();
        RelationVo relationVo = null;

        //3.获取迭代器第一个的字节码对象,获取类上的注解,里面包含着label
        NodeEntity annotation = nodes.iterator().next().getClass().getAnnotation(NodeEntity.class);
        String label = annotation.value();
        int type;
        switch (label) {
            case "paper":
                type = 3;break;
            case "keyword":
                type = 1;break;
            case "root":
                type = 4;break;
            case "team":
                type = 2;break;
            default:
                type = 0;break;
        }

        NodeVo nodeVo = null;
        List<NodeVo> list = new LinkedList<>();
        for (Node node : nodes) {
            nodeVo = new NodeVo();
            nodeVo.setId(node.getId() + "").setLabel(node.getLabel()).setType(type);
            list.add(nodeVo);
        }

        return list;
    }
}
