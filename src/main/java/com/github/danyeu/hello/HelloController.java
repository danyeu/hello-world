package com.github.danyeu.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {
    @Autowired
    private HelloService helloService;


    @GetMapping("/hello")
    public String hello() {
        if (Application.getBooleanFlag("hey")) {
            return helloService.getHey();
        }
        return helloService.getHello();
    }

}
