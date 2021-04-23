package com.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuweilong
 * @date 2021/4/22
 * @description
 */
@Configuration
public class DirectConfig {
    public static final String DIRECT_EXCHANGE_NAME = "direct.exchange";
    public static final String DIRECT_ROUTING_KEY = "direct.routing.key";
    public static final String DIRECT_QUEUE = "direct.queue";

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(DIRECT_EXCHANGE_NAME);
    }

    @Bean
    public Queue directQueue(){
        return new Queue(DIRECT_QUEUE, true);
    }

    @Bean
    public Binding directBinding(){
        return BindingBuilder.bind(directQueue())
                .to(directExchange())
                .with(DIRECT_ROUTING_KEY);
    }
}