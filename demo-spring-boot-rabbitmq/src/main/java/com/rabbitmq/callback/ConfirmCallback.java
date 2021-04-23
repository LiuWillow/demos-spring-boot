package com.rabbitmq.callback;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @author lwl
 * @date 2019/4/18 15:25
 * @description
 */
public class ConfirmCallback implements RabbitTemplate.ConfirmCallback {

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println("-------------进入MyConfirmCallback-------------");
        System.out.println(correlationData.getId());
        System.out.println(ack);
        System.out.println(cause);
    }
}