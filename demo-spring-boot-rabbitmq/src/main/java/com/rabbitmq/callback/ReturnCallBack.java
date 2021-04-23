package com.rabbitmq.callback;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @author lwl
 * @date 2019/4/18 14:33
 * @description
 */
public class ReturnCallBack implements RabbitTemplate.ReturnCallback {
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        System.out.println("----------进入FailedSendCallBack的confirm方法----------");
        System.out.println("replyCode : " + replyCode);
        System.out.println("replyText : " + replyText);
    }
}