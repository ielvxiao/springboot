package com.lvxiao.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Author lvxiao
 * Date 2018-12-08 21:58
 * Description: TODO
 * Version V1.0
 */
@Configuration
@MapperScan("com.lvxiao.dao")
public class MyBatisCofig {
}
