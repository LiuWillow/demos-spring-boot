package com.lwl.mybatis.origin.service;

import com.lwl.mybatis.origin.MySynchronization;
import com.lwl.mybatis.origin.entity.Sample;
import com.lwl.mybatis.origin.event.SimpleEvent;
import com.lwl.mybatis.origin.event.TransactionSampleFinishedEvent;
import com.lwl.mybatis.origin.mapper.SampleMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * author liuweilong
 * date 2019/12/27 2:58 下午
 * desc
 */
@Service
@Slf4j
public class SampleServiceImpl implements SampleService {
    @Autowired
    private SampleMapper sampleMapper;
    @Autowired
    private ApplicationEventPublisher publisher;

    @Override
    public Sample getById(Long id) {
        return sampleMapper.findById(id);
    }

    /**
     * 试试debug事务
     *
     * @param id
     * @return
     */
    @Override
    @Transactional
    public Sample updateAndGet(Long id) {
//        TransactionSynchronizationManager.registerSynchronization(new MySynchronization());
        sampleMapper.updateById(id);
        Sample sample = sampleMapper.findById(id);
        SimpleEvent simpleEvent = new SimpleEvent(this);
        simpleEvent.setMessage("简单事件");
        publisher.publishEvent(simpleEvent);

        TransactionSampleFinishedEvent transactionSampleFinishedEvent = new TransactionSampleFinishedEvent();
        transactionSampleFinishedEvent.setMessage(sample.toString());
        publisher.publishEvent(transactionSampleFinishedEvent);
        return sample;
    }
}