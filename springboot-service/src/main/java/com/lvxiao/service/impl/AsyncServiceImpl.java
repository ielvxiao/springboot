package com.lvxiao.service.impl;

import com.lvxiao.service.AsyncService;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Author lvxiao
 * Date 2019-01-06 00:52
 * Description: 异步服务方法实现
 * Version V1.0
 */
@Log4j2
@Service
public class AsyncServiceImpl implements AsyncService {
    @Override
    @Async //声明使用异步调用
    public void generateReport() {
        //打印异步线程名称
        log.debug("方法{}的线程名称是{}。", Thread.currentThread().getStackTrace()[1].getMethodName(),Thread.currentThread().getName());
    }
}
