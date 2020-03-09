package com.lwl.mybatis.origin.listener;

import com.alibaba.fastjson.JSON;
import com.lwl.mybatis.origin.event.SimpleEvent;
import com.lwl.mybatis.origin.event.TransactionSampleFinishedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * liuweilong
 */
@Slf4j
@Component
public class SimpleListener implements ApplicationListener<SimpleEvent> {

    @Override
    public void onApplicationEvent(SimpleEvent event) {
        log.info("收到简单事件：{}", JSON.toJSONString(event));
        /**
         * do something
         */
    }
}
