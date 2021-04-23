package com.rabbitmq.config;

import com.rabbitmq.callback.ReturnCallBack;
import com.rabbitmq.callback.ConfirmCallback;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AmqpConfig {
    /**
     * 如果要设置回调类，则用prototype
     * @return
     */
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        //开启发送失败回调
        rabbitTemplate.setMandatory(true);
        //设置失败回调接口,当消息无法达到队列的时候即失败,失败的时候才会回调
        rabbitTemplate.setReturnCallback(new ReturnCallBack());
        //设置发送方确认回调接口,当消息无法发送Broker时,表示失败, 无论成功失败都回回调
        rabbitTemplate.setConfirmCallback(new ConfirmCallback());
        return rabbitTemplate;
    }
}