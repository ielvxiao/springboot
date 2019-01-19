package com.lvxiao;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Author lvxiao
 * Date 2018-12-03 22:19
 * Description: TODO
 * Version V1.0
 */
@SpringBootApplication
@EnableDubboConfiguration
public class SpringBootStarter extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStarter.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringBootStarter.class);
    }
}
