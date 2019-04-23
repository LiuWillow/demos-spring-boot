package com.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoSpringBootRabbitmqApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoSpringBootRabbitmqApplication.class, args);
    }
}