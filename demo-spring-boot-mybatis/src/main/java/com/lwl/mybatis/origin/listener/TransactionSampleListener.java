package com.lwl.mybatis.origin.listener;

import com.alibaba.fastjson.JSON;
import com.lwl.mybatis.origin.event.TransactionSampleFinishedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * liuwielong
 */
@Slf4j
@Component
public class TransactionSampleListener {


    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handleAuthChange(TransactionSampleFinishedEvent event) throws Exception{
        log.info("事务提交成功监听事件：{}", JSON.toJSONString(event));
        /**
         * do something
         */
    }
}
