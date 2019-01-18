package com.lvxiao.web;

import com.lvxiao.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author lvxiao
 * Date 2018-12-03 21:59
 * Description: TODO
 * Version V1.0
 */
@RestController
public class Helloworld {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello world";
    }

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "运行成功";
    }
}
