package com.crc.autogenerator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: chenrencun
 * @Date: 2020/1/16 15:16
 * @Description: mybatis生成代码封装类
 */
public class CodeGenerator {

    /**
     * 调用该方法，执行代码生成
     * @param config AutoGeneratorConfig类
     */
    public static void run(AutoGeneratorConfig config) {
        String tableName = getTableName("表名");
        String projectPath = getProjectPath(config);
        //代码生成器
        AutoGenerator mpg = new AutoGenerator();
        GlobalConfig gc = getGlobalConfig(config, projectPath);
        DataSourceConfig dsc = getDataSourceConfig(config);
        PackageConfig pc = getPackage(config, tableName);
        TemplateConfig templateConfig = getTemplateConfig(config);
        StrategyConfig strategy = getStrategyConfig(tableName);
        InjectionConfig injectionConfig = getInjectionConfig(projectPath);

        //全局配置
        mpg.setGlobalConfig(gc);

        //数据源配置
        mpg.setDataSource(dsc);

        //包配置
        mpg.setPackageInfo(pc);

        mpg.setCfg(injectionConfig);

//        //自定义配置
//        InjectionConfig cfg = new InjectionConfig() {
//            @Override
//            public void initMap() {
//                //to do nothing
//            }
//        };
//
//        //自定义输出配置
//        List<FileOutConfig> focList = new ArrayList<>();
//        //自定义配置会优先输出
//        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
//                return projectPath + "/src/main/resources/mapper/"
//                        + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
//            }
//        });
//        cfg.setFileOutConfigList(focList);
//        mpg.setCfg(cfg);

        // 配置模板
        mpg.setTemplate(templateConfig);


        //配置策略
        mpg.setStrategy(strategy);
        mpg.execute();
    }

    // 如果为模块化项目，则项目路径=项目路径+模块名称
    private static String getProjectPath(AutoGeneratorConfig config) {
        String project = System.getProperty("user.dir");
        if (config.getModelName() != null && !config.getModelName().equals("")) {
            project = project + "/" + config.getModelName();
        }
        return project;
    }

    private static String getTableName(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    //全局配置
    private static GlobalConfig getGlobalConfig(AutoGeneratorConfig config, String projectPath) {
        GlobalConfig gc = new GlobalConfig();

        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor(config.getAuthor());
        //自定义Service接口生成的文件名
        gc.setServiceName("%sDomainService");
        gc.setServiceImplName("%sDomainServiceImpl");
        gc.setOpen(false);
        gc.setBaseResultMap(true);
        gc.setDateType(DateType.SQL_PACK);
        gc.setSwagger2(true);
        return gc;
    }

    //数据源配置
    private static DataSourceConfig getDataSourceConfig(AutoGeneratorConfig config) {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(config.getDbType());
        dsc.setDriverName(config.getDataSourceDriverName());
        dsc.setUsername(config.getDataSourceUserName());
        dsc.setPassword(config.getDataSourcePassword());
        if (dsc.getDbType().equals(DbType.MYSQL)) {
            dsc.setUrl(config.getDataSourceUrl() + "?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8");
        } else {
            dsc.setUrl(config.getDataSourceUrl());
        }
        return dsc;
    }

    //包配置
    private static PackageConfig getPackage(AutoGeneratorConfig config, String tableName) {
        PackageConfig pc = new PackageConfig();
        pc.setParent(config.getPackageParent());
//                .setMapper("mapper");
        String moduleName = tableName.replace("_","").toLowerCase();
//        pc.setModuleName(moduleName);
        pc.setMapper(moduleName);
        pc.setEntity(moduleName);
        pc.setService(moduleName);
        pc.setServiceImpl(moduleName);
//        pc.setXml("mapper");
        return pc;
    }

    // 配置模板
    private static TemplateConfig getTemplateConfig(AutoGeneratorConfig config) {
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        if ( config.getTemplateEntity() != null) {
            templateConfig.setEntity(config.getTemplateEntity());
        } else {
            templateConfig.setEntity("templates/entity.java");
        }

        if ( config.getTemplateServiceImpl() != null) {
            templateConfig.setServiceImpl(config.getTemplateServiceImpl());
        } else {
            templateConfig.setServiceImpl("templates/serviceImpl.java");
        }

        if ( config.getTemplateService() != null) {
            templateConfig.setService(config.getTemplateService());
        } else {
            templateConfig.setService("templates/service.java");
        }

        if ( config.getTemplateMapper() != null) {
            templateConfig.setMapper(config.getTemplateMapper());
        } else {
            templateConfig.setMapper("templates/dao.java");
        }

        if ( config.getTemplateController() != null) {
            templateConfig.setController(config.getTemplateController());
        } else {
            templateConfig.setController("templates/controller.java");
        }
        templateConfig.setXml(null);
        return templateConfig;
    }

    private static StrategyConfig getStrategyConfig(String tableName) {
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setSuperEntityClass(BaseDomain.class);
//        //strategy.setSuperControllerClass("com.example.demo.model.BaseEntity");
//        strategy.setEntityLombokModel(true);//默认是false
        //strategy.setRestControllerStyle(true);
        //公共父类
        //strategy.setSuperControllerClass("com.example.demo.controller.BaseController");
        // 写于父类中的公共字段
        //strategy.setSuperEntityColumns("id");
//        strategy.setControllerMappingHyphenStyle(true);
//        strategy.setC
//        strategy.setInclude("population_org_rel");
//        strategy.setInclude("tb_account");
        strategy.setInclude(tableName.toUpperCase());
//        strategy.setControllerMappingHyphenStyle(true);
//        strategy.setTablePrefix("tb_");
        return strategy;
    }

    private static InjectionConfig getInjectionConfig(final String projectPath) {
                //自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                //to do nothing
            }
        };
        //自定义输出配置
        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
        //自定义配置会优先输出
        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/"
                        + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        return cfg;
    }
}
