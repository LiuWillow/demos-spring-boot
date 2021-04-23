package com.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.retry.MessageRecoverer;
import org.springframework.amqp.rabbit.retry.RepublishMessageRecoverer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuweilong
 * @date 2021/4/22
 * @description
 */
@Configuration
public class RetryConfig {
    public static final String RETRY_DIRECT_EXCHANGE_NAME = "retry.direct.exchange";
    public static final String RETRY_DIRECT_ROUTING_KEY = "retry.direct.routing.key";
    public static final String RETRY_DIRECT_QUEUE = "retry.direct.queue";

    public static final String RETRY_DEAD_ROUTING_KEY = "retry.dead.routing.key";
    public static final String RETRY_DEAD_EXCHANGE = "retry.dead.exchange";
    public static final String RETRY_DEAD_QUEUE = "retry.dead.queue";

    @Bean
    public DirectExchange retryDirectExchange(){
        return new DirectExchange(RETRY_DIRECT_EXCHANGE_NAME, true, false);
    }

    @Bean
    public Queue retryDirectQueue(){
        return QueueBuilder.durable(RETRY_DIRECT_QUEUE)
                .withArgument("x-dead-letter-exchange", RETRY_DEAD_EXCHANGE) //绑定死信交换机
                .withArgument("x-dead-letter-routing-key", RETRY_DEAD_ROUTING_KEY)  //绑定私信路由
                //.withArgument("x-message-ttl", "1000")   也可以用这个来指定队列中所有消息的过期时间，可兼容，自动选最小的
                .build();
    }

    @Bean
    public Binding retryDirectBinding(){
        return BindingBuilder.bind(retryDirectQueue())
                .to(retryDirectExchange())
                .with(RETRY_DIRECT_ROUTING_KEY);
    }

    @Bean
    public DirectExchange retryDeadExchange(){
        return new DirectExchange(RETRY_DEAD_EXCHANGE, true, false);
    }

    @Bean
    public Queue retryDeadQueue(){
        return new Queue(RETRY_DEAD_QUEUE, true);
    }

    @Bean
    public Binding retryDeadBinding() {
        return BindingBuilder.bind(retryDeadQueue())
                .to(retryDeadExchange())
                .with(RETRY_DEAD_ROUTING_KEY);
    }

    @Bean
    public MessageRecoverer messageRecoverer(RabbitTemplate rabbitTemplate){
        return new RepublishMessageRecoverer(rabbitTemplate,RETRY_DEAD_EXCHANGE, RETRY_DEAD_ROUTING_KEY);
    }


    public static class Delta {
        //判断是否重新接收
        private String guid;
        //发这条消息的时候，前端收到的上一条消息的version，这个version由
        private Integer contextVersion;
        //发消息的用户id/客服id对应的guid
        private String fromUserGuid;
        //会话id，用于查询到底发给哪个客服/用户
        private String sessionId;
        //目标用户/客服的guid
        private String targetUserGuid;
        //内容
        private String content;
    }
}

//guid: 判断是否重复接收，防止前端由于网络延迟发起的消息重试
//contextVersion: 一个会话对应的对话序列号，自增，

//提供根据contextVersion间隔获取对应会话数据的http接口

//1、前端检测到websocket连接断开，主动拉取一次
//2、前端发现后端推送过来的contextVersion不是自增的，主动拉取一次，如前端最新的version是
