package com.rabbitmq.consumer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.config.AmqpConfig;
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
public class Topic1Listener {
    @RabbitHandler
    @RabbitListener(queues = TopicConfig.TOPIC_QUEUE1)
    public void handle(Message message, Channel channel) throws IOException {
        byte[] body = message.getBody();
        if (body != null && body.length > 0) {
            String json = new String(body, StandardCharsets.UTF_8);
            log.info("topic1队列:{}  接收到消息：{}", TopicConfig.TOPIC_QUEUE1, json);
            if ("true".equals(json)) {
                //第二个参数表示是否批量处理
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
                log.info("手动ack成功");
            } else {
                //第二个参数表示是否批量处理，第三个参数表示是返回原来队列还是消息作废不返回队列
                //如果返回原队列,如果消息是有问题的,则回不断消费
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
                //与上面一样
//                channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
                log.error("消费失败,回滚队列");
            }
        }
    }
}