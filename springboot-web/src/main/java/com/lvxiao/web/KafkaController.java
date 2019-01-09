package com.lvxiao.web;

import com.alibaba.fastjson.JSON;
import com.lvxiao.domain.User;
import com.lvxiao.service.impl.IndicatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Author lvxiao
 * Date 2019-01-06 17:26
 * Description: TODO
 * Version V1.0
 */
@Controller
@RequestMapping("/kafka")
public class KafkaController {

    private final IndicatorService indicatorService;

    @Autowired
    public KafkaController(IndicatorService indicatorService) {
        this.indicatorService = indicatorService;
    }

    @RequestMapping("/test")
    @ResponseBody
    public String testKafka(@RequestParam(name = "topic_value", required = true) String topic
            , @RequestParam(name = "user_id", required = false,defaultValue = "0") Integer id
            , @RequestParam(name = "user_age") Integer age, @RequestParam(name = "user_name", required = false, defaultValue = "defaultValue") String name) {
        User user = new User(id, name, age);
        String jsonStr = JSON.toJSONString(user);
        indicatorService.sendMessage(topic, jsonStr);
        return user.toString();
    }
}
