package com.lvxiao.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * Author lvxiao
 * Date 2019-01-05 01:05
 * Description: TODO
 * Version V1.0
 */
@Controller
@RequestMapping("/advice")
public class AdviceConstroller {

    private static Logger logger = LogManager.getLogger(AdviceConstroller.class);
    @RequestMapping("/exception")
    public String test(Date date, ModelMap modelMap) {
        logger.debug("获取的参数是{}", modelMap.get("project_name"));
        throw new RuntimeException("我是测试的异常");
    }
}
