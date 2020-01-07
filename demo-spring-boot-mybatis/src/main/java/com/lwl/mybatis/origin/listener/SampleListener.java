package com.lwl.mybatis.origin.listener;

import com.alibaba.fastjson.JSON;
import com.lwl.mybatis.origin.event.SampleFinishedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * Created by hedecai on 2019/12/26.
 * 空间或者文档权限变更事务提交成功   监听器
 * 处理空间、文档权限 同步到ES的操作
 */
@Slf4j
@Component
public class SampleListener {

    /**
     * 事务提交成功的时候回调该方法，最好是异步处理
     * @param event
     * @throws Exception
     */
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handleAuthChange(SampleFinishedEvent event) throws Exception{
        log.info("事务提交成功监听事件：{}", JSON.toJSONString(event));
        /**
         * do something
         */
    }
}
