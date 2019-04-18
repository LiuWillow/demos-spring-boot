package com.rabbitmq;

import com.rabbitmq.config.AmqpConfig;
import com.rabbitmq.sender.RabbitMQSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoSpringBootRabbitmqApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoSpringBootRabbitmqApplication.class, args);
    }
    @Autowired
    private RabbitMQSendService mqSendService;
    @GetMapping("")
    public String sendDelay(){
        mqSendService.sendDelay("这是一条延迟消息");
        return "success";
    }

    @GetMapping("topic")
    public String sendTopic(String routingKey){
        mqSendService.sendTopic("这是一条topic消息", routingKey);
        return "success";
    }
}