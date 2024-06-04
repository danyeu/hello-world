package com.github.danyeu.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        // mvn clean install
        // docker compose up --build
        // compose needed to port forward 8080:8080

    }
}
