package com.lvxiao.com.lvxiao.web;

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

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello world";
    }
}
