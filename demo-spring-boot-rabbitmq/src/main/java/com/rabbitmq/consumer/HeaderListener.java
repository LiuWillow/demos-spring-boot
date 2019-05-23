package com.rabbitmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HeaderListener {
    @RabbitHandler
    @RabbitListener(queues = "header.queue.lwl")
    public void handle(String msg) {
        log.info("队列header.queue.lwl接收到消息：{}", msg);
    }
}