package com.lvxiao.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Author lvxiao
 * Date 2019-01-02 23:37
 * Description: 支持MyBatis多数据源
 * Version V1.0
 */
@Configuration
@MapperScan(basePackages = {"com.lvxiao.dao.user"},sqlSessionTemplateRef = "userSqlSessionTemplate")
public class UserDataSourceConfig {
    @Bean(name = "userDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.user")
    public DataSource userDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "userSqlSessionFactory")
    @Primary
    public SqlSessionFactory userSqlSessionFactory(@Qualifier("userDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/user/*.xml"));
        return factoryBean.getObject();
    }

    @Bean(name="userTransactionManager")
    @Primary
    public DataSourceTransactionManager testTransactionManager(@Qualifier("userDataSource") DataSource dataSource){
        return  new DataSourceTransactionManager(dataSource);
    }
    @Bean(name = "userSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate userSqlSessionTemplate(@Qualifier("userSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
