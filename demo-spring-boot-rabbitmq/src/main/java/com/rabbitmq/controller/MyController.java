package com.rabbitmq.controller;

import com.rabbitmq.config.AmqpConfig;
import com.rabbitmq.sender.RabbitMQSendService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lwl
 * @date 2019/4/18 17:15
 * @description
 */
@RestController
public class MyController {
    @Autowired
    private RabbitMQSendService mqSendService;
    @Autowired
    private RabbitTemplate rabbitTemplate;
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
    @GetMapping("topic/callback")
    public String sendTopicCallback(String routingKey, String id, String msg){
        rabbitTemplate.convertAndSend(AmqpConfig.TOPIC_EXCHANGE, routingKey, msg, new CorrelationData(id));
        return "success";
    }
}