package cn.van.mybatis.multipledata.simple.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Copyright (C), 2015-2019, 风尘博客
 * 公众号 : 风尘博客
 * FileName: DataSource2Config
 * @author: Van
 * Date:     2019-03-26 15:08
 * Description: 从库数据源配置
 * Version： V1.0
 */
@Configuration
@MapperScan(basePackages = "cn.van.mybatis.multipledata.simple.mapper.slave", sqlSessionTemplateRef  = "db2SqlSessionTemplate")
// 指定分库扫描的 dao包，并给 dao层注入指定的 SqlSessionTemplate
public class DataSource2Config {
    //    首先创建 DataSource
    @Bean(name = "db2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.slave")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }
    //  然后创建 SqlSessionFactory
    @Bean(name = "db2SqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("db2DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return bean.getObject();
    }
    //  再创建事务
    @Bean(name = "db2TransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("db2DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
    //  最后包装到 SqlSessionTemplate 中
    @Bean(name = "db2SqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("db2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}