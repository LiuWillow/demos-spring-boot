package com.lwl.plus.util;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuweilong
 * @description
 * @date 2019/7/1 17:24
 */
public class MapperGenerator {

    /**
     * /extr/usr/xmgit/custom-service-refund/cs-refund-entity
     * RUN THIS
     */
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();
        GlobalConfig gc = new GlobalConfig();
        //是否覆盖原代码
        gc.setFileOverride(true);
        //配置项目路径

        String projectPath = "/Users/xmly/IdeaProjects/demos-spring-boot/demo-spring-boot-mybatis-plus";
        //输出路径
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("liuweilong");
        gc.setOpen(false);
        //设置entity后缀
        gc.setEntityName("%sPO");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        //日期转换为java.util.Date
        gc.setDateType(DateType.ONLY_DATE);

        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/db?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        //生成的文件会再这个包下
        pc.setParent("com.lwl.plus");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/src/main/resources/mapper"
                        + "/" + tableInfo.getMapperName() + StringPool.DOT_XML;
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setSuperServiceClass(null);
        strategy.setSuperServiceImplClass(null);

        strategy.setRestControllerStyle(true);

        //如果不配置，则生成db下所有的表
        strategy.setInclude("t_test");
        strategy.setControllerMappingHyphenStyle(true);
        //生成实体名的时候自动删除表前缀
        strategy.setTablePrefix("t_");
        mpg.setStrategy(strategy);

        // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}