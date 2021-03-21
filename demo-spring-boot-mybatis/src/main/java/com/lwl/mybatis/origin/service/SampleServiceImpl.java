//package com.lwl.mybatis.origin.service;
//
//import com.lwl.mybatis.origin.entity.Sample;
//import com.lwl.mybatis.origin.event.SimpleEvent;
//import com.lwl.mybatis.origin.event.TransactionSampleFinishedEvent;
//import com.lwl.mybatis.origin.mapper.SampleMapper;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.ApplicationEventPublisher;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//
///**
// * author liuweilong
// * date 2019/12/27 2:58 下午
// * desc
// */
//@Service
//@Slf4j
//@ConfigurationProperties(prefix = "task.enabled")
//public class SampleServiceImpl implements SampleService {
//    @Autowired
//    private SampleMapper sampleMapper;
//    @Autowired
//    private ApplicationEventPublisher publisher;
//    @Resource
//    private ShitService shitService;
//
//    private Set<String> taskDomains; //必须提供get set
//
//    private Set<String> shitDomains;
//
//    public Set<String> getShitDomains() {
//        return shitDomains;
//    }
//
//    public void setShitDomains(Set<String> shitDomains) {
//        this.shitDomains = shitDomains;
//    }
//
//    @Override
//    public Sample getById(Long id) {
//        return sampleMapper.findById(id);
//    }
//
//    /**
//     * 试试debug事务
//     *
//     * @param id
//     * @return
//     */
//    @Override
//    @Transactional
//    public Sample updateAndGet(Long id) {
//        sampleMapper.updateById(id);
//
//        shitService.haha();
//
//        Sample sample = sampleMapper.findById(id);
//        SimpleEvent simpleEvent = new SimpleEvent(this);
//        simpleEvent.setMessage("简单事件");
//        publisher.publishEvent(simpleEvent);
//
//        TransactionSampleFinishedEvent transactionSampleFinishedEvent = new TransactionSampleFinishedEvent();
//        transactionSampleFinishedEvent.setMessage(sample.toString());
//        publisher.publishEvent(transactionSampleFinishedEvent);
//        return sample;
//    }
//
//    @Override
//    public void tryOOM() {
//        List<Sample> samples = new ArrayList<>();
//        for (long i = 0; i < Long.MAX_VALUE; i++) {
//            final Sample sample = new Sample();
//            sample.setId(i);
//            samples.add(sample);
//        }
//        System.out.println(samples);
//    }
//
//    @Transactional
//    public void sample() {
//        System.out.println("sample");
//    }
//
//
//    public Set<String> getTaskDomains() {
//        return taskDomains;
//    }
//
//    public void setTaskDomains(Set<String> taskDomains) {
//        this.taskDomains = taskDomains;
//    }
//}