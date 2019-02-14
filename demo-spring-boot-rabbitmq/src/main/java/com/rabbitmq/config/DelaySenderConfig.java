package com.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lwl
 * @date 2019/1/28 19:02
 * @description
 */
@Configuration
public class DelaySenderConfig {
    /**
     * 原始交换机，初始消息发送到该交换机上
     */
    public static final String ORIGIN_DIRECT_EXCHANGE = "origin.direct.exchange";

    /**
     * 原始routing_key，初始消息通过该路由指定发送
     */
    public static final String ORIGIN_ROUTING_KEY = "origin.routing.key";
    /**
     * 原始队列，原始消息发到该队列
     */
    public static final String ORIGIN_QUEUE = "origin.queue";

    /**
     * 死信交换机，消息失效后转发到该交换机上面
     */
    public static final String DEAD_DIRECT_EXCHANGE = "dead.direct.exchange";
    /**
     * 死信routing_key，消息失效后转发到这个路由
     */
    public static final String DEAD_ROUTING_KEY = "dead.routing.key";

    /**
     * 定义初始队列，设置过期后该队列中消息的去处，该队列不需要我们监听
     */
    @Bean
    public Queue originQueue(){
        return QueueBuilder.durable(ORIGIN_QUEUE)
                .withArgument("x-dead-letter-exchange", DEAD_DIRECT_EXCHANGE)
                .withArgument("x-dead-letter-routing-key", DEAD_ROUTING_KEY)
                //.withArgument("x-message-ttl", "1000")   也可以用这个来指定队列中所有消息的过期时间，可兼容，自动选最小的
                .build();
    }

    /**
     * 定义原始交换机
     */
    @Bean
    public DirectExchange originDirectExchange(){
        return new DirectExchange(ORIGIN_DIRECT_EXCHANGE);
    }

    /**
     * 绑定原始队列到原始交换机
     */
    @Bean
    public Binding bindOriginQueue(DirectExchange originDirectExchange, Queue originQueue){
        return BindingBuilder.bind(originQueue).to(originDirectExchange).with(ORIGIN_ROUTING_KEY);
    }
}