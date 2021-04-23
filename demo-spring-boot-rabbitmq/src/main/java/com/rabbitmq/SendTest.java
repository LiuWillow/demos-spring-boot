package com.rabbitmq;

import com.rabbitmq.config.DirectConfig;
import com.rabbitmq.config.RetryConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author liuweilong
 * @date 2021/4/22
 * @description
 */
@Slf4j
public class SendTest {
    public static void main(String[] args) throws InterruptedException {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
        connectionFactory.setPort(5672);
        connectionFactory.setPassword("123");
        connectionFactory.setUsername("root");
        connectionFactory.setVirtualHost("dev");
        //发送端,如果要开启失败回调,也必须开启发送方确认
        connectionFactory.setPublisherConfirms(true);
//        connectionFactory.setPublisherReturns(true);

        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        //开启发送失败回调
        rabbitTemplate.setMandatory(true);
        //设置失败回调接口,当消息无法达到队列的时候即失败,失败的时候才会回调
        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int i, String s, String s1, String s2) {
                log.info("回调returnCallback");
            }
        });
        //设置发送方确认回调接口,当消息无法发送Broker时,表示失败, 无论成功失败都回回调
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean b, String s) {
                log.info("回调confirmCallback");
            }
        });

        rabbitTemplate.convertAndSend(RetryConfig.RETRY_DIRECT_EXCHANGE_NAME, RetryConfig.RETRY_DIRECT_ROUTING_KEY, "shit");
        TimeUnit.SECONDS.sleep(10);
    }


}
