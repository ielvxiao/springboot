package com.lvxiao.web;

import com.lvxiao.domain.User;
import com.lvxiao.service.impl.IndicatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String testKafka(String topic, Integer id, Integer age, String name) {
        User user = new User(id, name, age);
        indicatorService.sendMessage(topic, user);
        return user.toString();
    }
}
