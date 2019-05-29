package com.rabbitmq.config;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuweilong
 * @description
 * @date 2019/5/23 15:19
 */
@Configuration
public class TxConfig {
    @Autowired
    private ConnectionFactory connectionFactory;
    @Bean
    public SimpleMessageListenerContainer messageListenerContainer(){
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
//        container.setTransactionManager();
        return container;
    }
}
