package com.lvxiao;

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
public class SpringBootStarter extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStarter.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringBootStarter.class);
    }
}
