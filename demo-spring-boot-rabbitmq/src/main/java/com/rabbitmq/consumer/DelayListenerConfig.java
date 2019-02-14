package com.rabbitmq.consumer;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lwl
 * @date 2019/1/28 19:56
 * @description
 */
@Configuration
public class DelayListenerConfig {
    /**
     * 死信交换机
     */
    public static final String DEAD_DIRECT_EXCHANGE = "dead.direct.exchange";
    /**
     * 死信路由
     */
    public static final String DEAD_ROUTING_KEY = "dead.routing.key";
    /**
     * 死信队列
     */
    public static final String DEAD_QUEUE = "dead.queue";

    /**
     * 定义死信队列，原始队列中消息失效后发送到该队列（事实上是发送到死信路由，路由绑定队列），我们监听的队列
     */
    @Bean
    public Queue deadQueue(){
        return new Queue(DEAD_QUEUE);
    }

    /**
     * 定义死信交换机
     */
    @Bean
    public DirectExchange deadDirectExchange(){
        return new DirectExchange(DEAD_DIRECT_EXCHANGE);
    }

    /**
     * 绑定死信队列到死信交换机
     */
    @Bean
    public Binding bindDeadQueue(DirectExchange deadDirectExchange, Queue deadQueue){
        return BindingBuilder.bind(deadQueue).to(deadDirectExchange).with(DEAD_ROUTING_KEY);
    }

}