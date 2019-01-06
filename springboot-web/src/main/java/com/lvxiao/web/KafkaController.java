package com.lvxiao.web;

import com.lvxiao.service.impl.IndicatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public void testKafka(String topic, String data) {
        indicatorService.sendMessage(topic, data);
    }
}
