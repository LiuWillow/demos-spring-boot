package com.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AmqpConfig {
    public static final String EXANGE_NAME = "lwl.exange";
    public static final String ROUTING_KEY = "lwl.routing.key";
    public static final String QUEUE_NAME = "lwl.queue";
    public static final String CORP_LOGO_FANOUT_EXCHANGE_STORE = "test.corp.fanout";
    public static final String CORP_LOGO_TOPIC_EXCHANGE_STORE = "test.corp.topic";
    public static final String CORP_LOGO_ROUTING_KEY = "test.routing";
    public static final String CHARGE_EXCHANGE = "test.charge";

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
    public TopicExchange topicExchange(){
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    @Bean
    public Queue topicQueue1(){
        return new Queue(TOPIC_QUEUE1);
    }

    @Bean
    public Queue topicQueue2(){
        return new Queue(TOPIC_QUEUE2);
    }

    @Bean
    public Binding bindTopicQueue1(TopicExchange topicExchange, Queue topicQueue1){
        return BindingBuilder.bind(topicQueue1).to(topicExchange).with(TOPIC_KEY);
    }
    @Bean
    public Binding bindTopicQueue2(TopicExchange topicExchange, Queue topicQueue2){
        return BindingBuilder.bind(topicQueue2).to(topicExchange).with(TOPIC_KEY_2);
    }
    @Bean
    @ConfigurationProperties(prefix = "spring.rabbitmq")
    public ConnectionFactory connectionFactory(){
        return new CachingConnectionFactory();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RabbitTemplate rabbitTemplate(){
        return new RabbitTemplate(connectionFactory());
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(EXANGE_NAME);
    }

    @Bean
    public Queue queue(){
        return new Queue(QUEUE_NAME, true);
    }

    @Bean
    public Binding binding(){
        return BindingBuilder.bind(queue())
                .to(directExchange())
                .with(AmqpConfig.ROUTING_KEY);
    }
}