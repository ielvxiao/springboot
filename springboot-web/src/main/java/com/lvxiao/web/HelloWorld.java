package com.lvxiao.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Author lvxiao
 * Date 2018-12-03 21:59
 * Description: TODO
 * Version V1.0
 */
@RestController
public class HelloWorld {

    @Autowired
    private HttpServletRequest request;
    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello world";
    }

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "运行成功! tomcat地址：" + request.getLocalAddr() + "。端口：" + request.getLocalPort();
    }
}
