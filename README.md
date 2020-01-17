本系统主要功能是代码生成器，基于mybatis-plus代码生成器，对其进行封装，以符合实际项目需求。
通过以下案例，可以基本了解如何使用该代码生成器：
```
package com.tianque.grid.gridcenter;

import com.baomidou.mybatisplus.annotation.DbType;
import com.tianque.grid.AutoGeneratorConfig;
import com.tianque.grid.CodeGenerator;

public class Test {
    public static void main(String[] args) {
        AutoGeneratorConfig config = new AutoGeneratorConfig();
        config.setModelName("modelname");
        config.setDbType(DbType.ORACLE);
        config.setDataSourceDriverName("oracle.jdbc.driver.OracleDriver");
        config.setDataSourceUrl("jdbc:oracle:thin:@192.168.100.250:1521:xxx");
        config.setDataSourceUserName("xxx");
        config.setDataSourcePassword("xxx");
        config.setPackageParent("com.crc.autogenerator.domain.model");
        config.setAuthor("chenrencun");
        config.setTemplateEntity("templates/entity.java");
        config.setTemplateMapper("templates/dao.java");
        config.setTemplateService("templates/service.java");
        config.setTemplateServiceImpl("templates/serviceImpl.java");
        CodeGenerator.run(config);
    }
}
```
对使用案例的说明：
    首先实例化一个AutoGeneratorConfig配置类，并设置属性，然后调用CodeGenerator的run方法，AutoGeneratorConfig配置类作为参数传入。
对AutoGeneratorConfig配置类的属性说明：

参数	|  名称  |   是否必填
 ---- | ----- | ------
modelName	  |          模块名称	
dbType	      |          数据库类型（默认mysql）	
dataSourceDriverName |	数据库驱动	         |         是
dataSourceUrl	     |   驱动连接的URL	      |        是
dataSourceUserName	 |   数据库连接用户名	    |        是
dataSourcePassword	 |   数据库连接密码	     |           是
author	              |  创建作者	
templateEntity	      |  输出模板（实体类）	
templateMapper	      |  输出模板（dao层）	
templateService	      |  输出模板（service层）	
templateServiceImpl	  |  输出模板（serviceImpl类）	
templateController	   | 输出模板（controller类）	

注意：
1.	实现该功能的前提是，需要在数据库中有对应的数据表。
2.	启动main方法后，控制台会显示"请输入表名："，待输入表名后，可以在项目中生成该数据表的相关代码。
