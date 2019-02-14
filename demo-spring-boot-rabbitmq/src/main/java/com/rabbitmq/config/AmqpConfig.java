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