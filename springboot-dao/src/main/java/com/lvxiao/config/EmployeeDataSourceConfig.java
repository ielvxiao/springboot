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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Author lvxiao
 * Date 2019-01-02 23:52
 * Description: employee多数据源设置
 * Version V1.0
 */
@Configuration
@MapperScan(basePackages = {"com.lvxiao.dao.employee"},sqlSessionTemplateRef = "employeeSqlSessionTemplate")
public class EmployeeDataSourceConfig {
    @Bean(name = "employeeDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.employee")
    public DataSource userDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "employeeSqlSessionFactory")
    public SqlSessionFactory userSqlSessionFactory(@Qualifier("employeeDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/employee/*.xml"));
        return factoryBean.getObject();
    }

    @Bean(name="employeeTransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("employeeDataSource") DataSource dataSource){
        return  new DataSourceTransactionManager(dataSource);
    }
    @Bean(name = "employeeSqlSessionTemplate")
    public SqlSessionTemplate userSqlSessionTemplate(@Qualifier("employeeSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
