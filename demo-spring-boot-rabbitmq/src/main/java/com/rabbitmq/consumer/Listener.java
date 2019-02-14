package com.rabbitmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues = "lwl.queue")
@Slf4j
public class Listener {
    @RabbitHandler
    public void handle(String msg){
        log.info("-------接收到的消息：" + msg + "------------");
    }
}