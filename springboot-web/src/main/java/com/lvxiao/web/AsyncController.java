package com.lvxiao.web;

import com.lvxiao.service.AsyncService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author lvxiao
 * Date 2019-01-06 00:58
 * Description: TODO
 * Version V1.0
 */
@Log4j2
@Controller
@RequestMapping("/async")
public class AsyncController {

    private final AsyncService asyncService;

    //spring team推荐的做法
    @Autowired
    public AsyncController(AsyncService asyncService) {
        this.asyncService = asyncService;
    }

    @RequestMapping("/page")
    public String asyncPage() {
        log.debug("方法{}的线程名称是{}。", Thread.currentThread().getStackTrace()[1].getMethodName(),Thread.currentThread().getName());
        asyncService.generateReport();
        return "async";
    }
}
