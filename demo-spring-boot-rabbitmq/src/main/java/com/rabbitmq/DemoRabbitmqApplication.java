package com.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableRetry //在amqp的包里包含了spring-retry
public class DemoRabbitmqApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoRabbitmqApplication.class, args);
    }
}