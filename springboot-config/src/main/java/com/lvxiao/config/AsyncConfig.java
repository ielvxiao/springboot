package com.lvxiao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * Author lvxiao
 * Date 2019-01-06 00:48
 * Description: 配置定义线程池和启用异步
 * Version V1.0
 */
@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {
    @Override
    public Executor getAsyncExecutor() {
        //定义线程池
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        //核心线程数
        taskExecutor.setCorePoolSize(10);
        //线程池最大线程数
        taskExecutor.setMaxPoolSize(100);
        //线程队列最大线程数
        taskExecutor.setQueueCapacity(5000);
        //初始化
        taskExecutor.initialize();
        return taskExecutor;
    }
}
