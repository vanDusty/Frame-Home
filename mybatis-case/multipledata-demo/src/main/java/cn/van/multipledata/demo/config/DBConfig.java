package cn.van.multipledata.demo.config;

import cn.van.multipledata.demo.enums.DynamicDSEnum;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DBConfig {

    /**
     * 主库
     * @return
     */
    @ConfigurationProperties(prefix = "spring.datasource.master")
    @Bean("masterDS")
    public DataSource masterDS() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 从库
     * @return
     */
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    @Bean("slaveDS")
    @Primary
    public DataSource slaveDS() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 主从动态配置
     */
    @Bean
    public DynamicDataSource dynamicDS(@Qualifier("masterDS") DataSource masterDataSource,
                                       @Autowired(required = false) @Qualifier("slaveDS") DataSource slaveDataSource) {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
        targetDataSources.put(DynamicDSEnum.MASTER.getDesc(), masterDataSource);
        if (slaveDataSource != null) {
            targetDataSources.put(DynamicDSEnum.SLAVE.getDesc(), slaveDataSource);
        }
        dynamicDataSource.setTargetDataSources(targetDataSources);
        dynamicDataSource.setDefaultTargetDataSource(masterDataSource);
        return dynamicDataSource;
    }

    @Bean
    public SqlSessionFactory sessionFactory(@Qualifier("dynamicDS") DataSource dynamicDataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*Mapper.xml"));
        bean.setDataSource(dynamicDataSource);
        return bean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlTemplate(@Qualifier("sessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = "dataSourceTx")
    public DataSourceTransactionManager dataSourceTx(@Qualifier("dynamicDS") DataSource dynamicDataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dynamicDataSource);
        return dataSourceTransactionManager;
    }
}
