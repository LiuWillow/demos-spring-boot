package com.mybatis.service;

import com.mybatis.dao.mapper.SampleMapper;
import com.mybatis.dao.mapper.ShitMapper;
import com.mybatis.entity.Sample;
import com.mybatis.entity.Shit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SampleServiceImpl implements SampleService {
    @Autowired
    private SampleMapper sampleMapper;
    @Autowired
    private ShitMapper shitMapper;

    @Override
    public Sample getById(Integer id) {
        return sampleMapper.getSampleById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertSample(Sample sample) {
        sampleMapper.insertOne(sample);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertShit(Shit shit) {
        shitMapper.insert(shit);
    }
}