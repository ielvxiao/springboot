package com.lvxiao.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lvxiao.service.dubbo.DubboTestService;
import org.springframework.stereotype.Component;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019-01-19 18:42
 */
@Service(version = "${demo.version}")
@Component
public class DubboTestServiceImpl implements DubboTestService {
    @Override
    public String sayHello(String name) {
        return "hello" + name;
    }
}
