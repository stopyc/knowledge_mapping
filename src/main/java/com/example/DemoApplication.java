package com.example;

import io.github.yedaxia.apidocs.Docs;
import io.github.yedaxia.apidocs.DocsConfig;
import io.github.yedaxia.apidocs.plugin.markdown.MarkdownDocPlugin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
////        //        //TODO API接口文档
////
//        DocsConfig config = new DocsConfig();
//
//        // 项目根目录
//        config.setProjectPath("E:\\github_project\\qg-knowledge-mapping\\knowledge_mapping");
//        // 项目名称
//        config.setProjectName("knowledge_mapping");
//        // 声明该API的版本
//        config.setApiVersion("V1.4.4");
//        // 生成API 文档所在目录
//        config.setDocsPath("E:\\api_docs\\knowledge_mapping");
//        // 配置自动生成
//        config.setAutoGenerate(Boolean.TRUE);
//        config.addPlugin(new MarkdownDocPlugin());
//        // 执行生成文档
//        Docs.buildHtmlDocs(config);
        SpringApplication.run(DemoApplication.class, args);
    }
}
