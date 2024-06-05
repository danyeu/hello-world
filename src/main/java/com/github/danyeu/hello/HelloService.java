package com.github.danyeu.hello;

import org.springframework.stereotype.Service;


@Service
public class HelloService {


    public String getHello() {
        return "Hello, world!";
    }

    public String getHey() {
        return "Hey, world!";
    }
}
