package com.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuweilong
 * @date 2021/4/22
 * @description
 */
@Configuration
public class HeadersConfig {
    public static final String HEADER_QUEUE = "header.queue";
    /**
     * 下面是头交换机
     */
    @Bean
    public HeadersExchange headersExchange(){
        return new HeadersExchange("header.exchange");
    }

    @Bean
    public Queue headerQueue(){
        return new Queue(HEADER_QUEUE);
    }

    @Bean
    public Binding bindHeaderQueue(HeadersExchange headersExchange, Queue headerQueue){
//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "lwl");
//        map.put("age", 23);
        /**
         * whereAny表示匹配任意
         */
//        BindingBuilder.bind(headerQueueLwl).to(headersExchange).whereAny("name", "age");
//        BindingBuilder.bind(headerQueueLwl).to(headersExchange).whereAny(map);
//        BindingBuilder.bind(headerQueueLwl).to(headersExchange).whereAll(map);

        //只要是header匹配到lwl的都发送
        return BindingBuilder.bind(headerQueue).to(headersExchange).where("name").matches("lwl");
    }
}
