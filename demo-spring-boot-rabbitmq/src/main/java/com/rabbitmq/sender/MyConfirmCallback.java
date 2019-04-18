package com.rabbitmq.sender;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;

/**
 * @author lwl
 * @date 2019/4/18 15:25
 * @description
 */
public class MyConfirmCallback implements RabbitTemplate.ConfirmCallback {

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println("-------------进入MyConfirmCallback-------------");
        System.out.println(correlationData.getId());
        System.out.println(ack);
        System.out.println(cause);
    }
}