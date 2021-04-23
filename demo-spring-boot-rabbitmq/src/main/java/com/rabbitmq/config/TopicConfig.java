package com.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuweilong
 * @date 2021/4/22
 * @description
 */
@Configuration
public class TopicConfig {
    public static final String TOPIC_EXCHANGE = "topic.exchange";
    public static final String TOPIC_QUEUE1 = "topic.queue1";
    public static final String TOPIC_QUEUE2 = "topic.queue2";

    /**
     * 如果生产者发送的消息是order.后面跟任何内容,都能够被交换机接收到
     */
    public static final String TOPIC_KEY = "order.#";
    /**
     * 只能匹配.后面的一个单词
     */
    public static final String TOPIC_KEY_2 = "order.*";

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    @Bean
    public Queue topicQueue1() {
        return new Queue(TOPIC_QUEUE1);
    }

    @Bean
    public Queue topicQueue2() {
        return new Queue(TOPIC_QUEUE2);
    }

    @Bean
    public Binding bindTopicQueue1(TopicExchange topicExchange, Queue topicQueue1) {
        return BindingBuilder.bind(topicQueue1).to(topicExchange).with(TOPIC_KEY);
    }

    @Bean
    public Binding bindTopicQueue2(TopicExchange topicExchange, Queue topicQueue2) {
        return BindingBuilder.bind(topicQueue2).to(topicExchange).with(TOPIC_KEY_2);
    }
}
