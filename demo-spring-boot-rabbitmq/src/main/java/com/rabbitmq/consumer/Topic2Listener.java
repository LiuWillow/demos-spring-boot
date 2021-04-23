package com.rabbitmq.consumer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.config.DelayConfig;
import com.rabbitmq.config.TopicConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
@Slf4j
public class Topic2Listener {
    @RabbitHandler
    @RabbitListener(queues = TopicConfig.TOPIC_QUEUE2)
    public void handle(Message message, Channel channel) throws IOException {
        byte[] body = message.getBody();
        if (body != null && body.length > 0) {
            String json = new String(body, StandardCharsets.UTF_8);
            log.info("topic2队列:{} 接收到消息: {}", TopicConfig.TOPIC_QUEUE2, json);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        }
    }
}