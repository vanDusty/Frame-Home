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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Copyright (C), 2015-2019, 风尘博客
 * 公众号 : 风尘博客
 * FileName: DataSource1Config
 * @author: Van
 * Date:     2019-03-26 15:05
 * Description: 主数据源配置
 * Version： V1.0
 */
@Configuration
@MapperScan(basePackages = "cn.van.mybatis.multipledata.simple.mapper.master", sqlSessionTemplateRef  = "masterSqlSessionTemplate")
// 指定主库扫描的 dao包，并给 dao层注入指定的 SqlSessionTemplate
public class DataSource1Config {
//    首先创建 DataSource
    @Bean(name = "masterDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.master")
    @Primary // 指定是主库
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }
//  然后创建 SqlSessionFactory
    @Bean(name = "masterSqlSessionFactory")
    @Primary
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("masterDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return bean.getObject();
    }
//  再创建事务
    @Bean(name = "masterTransactionManager")
    @Primary
    public DataSourceTransactionManager testTransactionManager(@Qualifier("masterDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
//  最后包装到 SqlSessionTemplate 中
    @Bean(name = "masterSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("masterSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}