package com.rabbitmq.consumer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.config.RetryConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author liuweilong
 * @date 2021/4/23
 * @description
 */
//@Service
@Slf4j
public class RetryDeadListener {
    @RabbitHandler
    @RabbitListener(queues = RetryConfig.RETRY_DEAD_QUEUE)
    public void handleDead(Message message, Channel channel) throws IOException {
        log.info("retry死信队列:{} 接收到消息", RetryConfig.RETRY_DIRECT_QUEUE);
        byte[] body = message.getBody();
        if (body != null && body.length > 0) {
            String json = new String(body, StandardCharsets.UTF_8);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        }
    }
}