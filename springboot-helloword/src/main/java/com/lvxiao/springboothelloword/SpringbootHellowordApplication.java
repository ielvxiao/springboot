package com.lvxiao.springboothelloword;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootHellowordApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootHellowordApplication.class, args);
    }

    @RequestMapping("/hello")
    public String helloWord() {
        return "helloWord";
    }
}
