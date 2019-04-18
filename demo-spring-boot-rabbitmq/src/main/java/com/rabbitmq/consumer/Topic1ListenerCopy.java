package com.rabbitmq.consumer;

import com.rabbitmq.config.AmqpConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Topic1ListenerCopy {
    @RabbitHandler
    @RabbitListener(queues = AmqpConfig.TOPIC_QUEUE1)
    public void handle(String msg) {
        log.info("队列" + AmqpConfig.TOPIC_QUEUE1 + "接收到消息：" + msg);
    }
}