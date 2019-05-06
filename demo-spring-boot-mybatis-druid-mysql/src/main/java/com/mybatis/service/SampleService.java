package com.mybatis.service;

import com.mybatis.dao.mapper.SampleMapper;
import com.mybatis.dao.mapper.ShitMapper;
import com.mybatis.entity.Sample;
import com.mybatis.entity.Shit;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SampleService {
    @Autowired
    private SampleMapper sampleMapper;
    @Autowired
    private ShitMapper shitMapper;

    public Sample getById(Integer id) {
        return sampleMapper.getSampleById(id);
    }

    public void insertSample(Sample sample) {
        SampleService sampleService = (SampleService) AopContext.currentProxy();
        sampleMapper.insertOne(sample);
        Shit shit = new Shit();
        shit.setSmell("chou");
        sampleService.insertShit(shit);
    }

    @Transactional(rollbackFor = Exception.class)
    public void insertShit(Shit shit) {
        shitMapper.insert(shit);
        System.out.println();
    }
}