package com.rabbitmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DelayListener {
    @RabbitHandler
    @RabbitListener(queues = DelayListenerConfig.DEAD_QUEUE)
    public void handle(String msg) {
        log.info("队列" + DelayListenerConfig.DEAD_QUEUE + "接收到消息：" + msg);
    }
}