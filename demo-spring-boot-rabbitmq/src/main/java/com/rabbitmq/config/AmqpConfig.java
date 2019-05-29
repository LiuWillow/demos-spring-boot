package com.rabbitmq.config;

import com.rabbitmq.sender.FailedSendCallBack;
import com.rabbitmq.sender.MyConfirmCallback;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AmqpConfig {
    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("111.231.217.106");
        connectionFactory.setPassword("ca_rabbitmq2018");
        connectionFactory.setUsername("ca_rabbitmq");
        connectionFactory.setVirtualHost("dev");
        //发送端,如果要开启失败回调,也必须开启发送方确认
        connectionFactory.setPublisherConfirms(true);
        return connectionFactory;
    }

    @Bean
    public SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory (ConnectionFactory connectionFactory){
        SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory = new SimpleRabbitListenerContainerFactory();
        simpleRabbitListenerContainerFactory.setConnectionFactory(connectionFactory);
        //消费端手动确认
        simpleRabbitListenerContainerFactory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        return simpleRabbitListenerContainerFactory;
    }

    /**
     * 如果要设置回调类，则用prototype
     * @return
     */
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RabbitTemplate rabbitTemplate(){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        //开启发送失败回调
        rabbitTemplate.setMandatory(true);
        //设置失败回调接口,当消息无法达到队列的时候即失败,失败的时候才会回调
        rabbitTemplate.setReturnCallback(new FailedSendCallBack());
        //设置发送方确认回调接口,当消息无法发送Broker时,表示失败, 无论成功失败都回回调
        rabbitTemplate.setConfirmCallback(new MyConfirmCallback());
        //是否开启事务，
//        rabbitTemplate.setChannelTransacted(true);
        return rabbitTemplate;
    }
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

    /**
     * 下面是头交换机
     */
    @Bean
    public HeadersExchange headersExchange(){
        return new HeadersExchange("header.exchange.lwl");
    }

    @Bean
    public Queue headerQueueLwl(){
        return new Queue("header.queue.lwl");
    }

    @Bean
    public Binding bindHeaderQueueLwl(HeadersExchange headersExchange, Queue headerQueueLwl){
//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "lwl");
//        map.put("age", 23);
        /**
         * whereAny表示匹配任意
         */
//        BindingBuilder.bind(headerQueueLwl).to(headersExchange).whereAny("name", "age");
//        BindingBuilder.bind(headerQueueLwl).to(headersExchange).whereAny(map);
//        BindingBuilder.bind(headerQueueLwl).to(headersExchange).whereAll(map);
        return BindingBuilder.bind(headerQueueLwl).to(headersExchange).where("name").matches("lwl");
    }
}