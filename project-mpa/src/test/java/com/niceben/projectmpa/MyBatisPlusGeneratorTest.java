package com.niceben.projectmpa;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.niceben.projectmpa.mapper.model.entity.BaseEntity;

import java.util.Collections;

public class MyBatisPlusGeneratorTest {

    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir") + "/project-mpa";
        String moduleName = "rbac";
        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/mysqlConn?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=GMT%2b8&nullCatalogMeansCurrent=true", "root", "123456")
                .globalConfig(builder -> {
                    builder.author("NiceBen") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(projectPath + "/src/main/java") // 指定输出目录
                            .disableOpenDir();      // 禁止打开输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.niceben.projectmpa.business") // 设置父包名
                            .moduleName(moduleName) // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, projectPath + "/src/main/resources/mapper/" + moduleName + "/")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("user") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .strategyConfig( builder -> {
                    builder.entityBuilder()
                            .superClass(BaseEntity.class)
                            .disableSerialVersionUID()
                            .enableChainModel()
                            .enableLombok()
                            .build();
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
