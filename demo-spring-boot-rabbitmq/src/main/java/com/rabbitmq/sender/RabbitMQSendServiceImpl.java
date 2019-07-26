package com.rabbitmq.sender;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.config.AmqpConfig;
import com.rabbitmq.config.DelaySenderConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.MessagePropertiesBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class RabbitMQSendServiceImpl implements RabbitMQSendService, RabbitTemplate.ConfirmCallback {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendFanout(String msg) {
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(AmqpConfig.EXANGE_NAME, AmqpConfig.ROUTING_KEY, msg, correlationData);
    }

    @Override
    public void sendFanout(CorpLogoModel corpLogoModel, String fanoutExhcangeName) {
        rabbitTemplate.convertAndSend(fanoutExhcangeName, "", JSON.toJSONString(corpLogoModel));
    }

    @Override
    public void sendTopic(String message, String routingKey) {
        rabbitTemplate.convertAndSend(AmqpConfig.TOPIC_EXCHANGE, routingKey, message);
    }

    @Override
    public void sendCloseStore(ChargeMqSenderModel model) {
        String json = JSON.toJSONString(model);
        rabbitTemplate.convertAndSend(AmqpConfig.CHARGE_EXCHANGE, "", json);
    }

    @Override
    public void sendDelay(String msgDelay) {
        //消息发到原始队列，5s后消息到期，转发到死信路由绑定的死信队列，然后被消费
        rabbitTemplate.convertAndSend(DelaySenderConfig.ORIGIN_DIRECT_EXCHANGE, DelaySenderConfig.ORIGIN_ROUTING_KEY,
                msgDelay, msg -> {
                    msg.getMessageProperties().setExpiration(10 * 3600 * 1000 + "");
                    return msg;
                });
        log.info("成功发送延迟消息: " + msgDelay);
    }

    @Override
    public void sendHeader(String msg) {
        MessageProperties messageProperties = MessagePropertiesBuilder.newInstance()
                .setContentType(MessageProperties.CONTENT_TYPE_TEXT_PLAIN)
                .setMessageId("123")
                .setHeader("name", "lwl")
                .setHeader("age", 23).build();

        Message message = MessageBuilder.withBody(msg.getBytes()).andProperties(messageProperties).build();
        rabbitTemplate.convertAndSend("headersExchange", "", message);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        log.info("回调id：" + correlationData);
        if (b) {
            log.info("回调-------消费成功------");
            return;
        }
        log.info("回调-------消费失败-----------");
    }
}
