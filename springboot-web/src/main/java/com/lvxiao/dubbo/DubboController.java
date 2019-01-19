package com.lvxiao.dubbo;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lvxiao.service.dubbo.DubboTestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019-01-19 19:36
 */
@RestController
public class DubboController {
    @Reference(version = "${demo.version}")
    private DubboTestService dubboTestService;

    @RequestMapping("/consumer")
    public String dubbo() {
        return dubboTestService.sayHello("test");
    }
}
