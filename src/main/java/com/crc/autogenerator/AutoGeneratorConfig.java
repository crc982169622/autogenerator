package com.crc.autogenerator;

import com.baomidou.mybatisplus.annotation.DbType;

import java.io.Serializable;

/**
 * @Author: chenrencun
 * @Date: 2020/1/16 14:43
 * @Description: mybaits plus代码生成器配置类
 */
public class AutoGeneratorConfig implements Serializable {

    /** 模块名（若为模块化项目，则需要填写，否则不填） */
    private String modelName;

    /** 包名（在此包名位置下生成代码） */
    private String packageParent;

    /** 数据库类型（例如DbType.ORACLE） */
    private DbType dbType;

    /** 数据源驱动名称 */
    private String dataSourceDriverName;

    /** 驱动连接的URL */
    private String dataSourceUrl;

    /** 数据库连接用户名 */
    private String dataSourceUserName;

    /** 数据库连接密码 */
    private String dataSourcePassword;

    /** 自定义输出模板（实体类） 注意不要带上.ftl/.vm */
    private String templateEntity;

    /** 自定义输出模板（dao层） */
    private String templateMapper;

    /** 自定义输出模板（service层） */
    private String templateService;

    /** 自定义输出模板（serviceImpl类） */
    private String templateServiceImpl;

    /** 自定义输出模板（controller类） */
    private String templateController;

    /** 创建者 */
    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public DbType getDbType() {
        return dbType;
    }

    public void setDbType(DbType dbType) {
        this.dbType = dbType;
    }

    public String getDataSourceDriverName() {
        return dataSourceDriverName;
    }

    public void setDataSourceDriverName(String dataSourceDriverName) {
        this.dataSourceDriverName = dataSourceDriverName;
    }

    public String getDataSourceUrl() {
        return dataSourceUrl;
    }

    public void setDataSourceUrl(String dataSourceUrl) {
        this.dataSourceUrl = dataSourceUrl;
    }

    public String getDataSourceUserName() {
        return dataSourceUserName;
    }

    public void setDataSourceUserName(String dataSourceUserName) {
        this.dataSourceUserName = dataSourceUserName;
    }

    public String getDataSourcePassword() {
        return dataSourcePassword;
    }

    public void setDataSourcePassword(String dataSourcePassword) {
        this.dataSourcePassword = dataSourcePassword;
    }

    public String getPackageParent() {
        return packageParent;
    }

    public void setPackageParent(String packageParent) {
        this.packageParent = packageParent;
    }

    public String getTemplateEntity() {
        return templateEntity;
    }

    public void setTemplateEntity(String templateEntity) {
        this.templateEntity = templateEntity;
    }

    public String getTemplateMapper() {
        return templateMapper;
    }

    public void setTemplateMapper(String templateMapper) {
        this.templateMapper = templateMapper;
    }

    public String getTemplateService() {
        return templateService;
    }

    public void setTemplateService(String templateService) {
        this.templateService = templateService;
    }

    public String getTemplateServiceImpl() {
        return templateServiceImpl;
    }

    public void setTemplateServiceImpl(String templateServiceImpl) {
        this.templateServiceImpl = templateServiceImpl;
    }

    public String getTemplateController() {
        return templateController;
    }

    public void setTemplateController(String templateController) {
        this.templateController = templateController;
    }
}
