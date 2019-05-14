package com.mybatis.service;

import com.mybatis.dao.mapper.SampleMapper;
import com.mybatis.dao.mapper.ShitMapper;
import com.mybatis.entity.Sample;
import com.mybatis.entity.Shit;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class SampleService {
    @Autowired
    private SampleService sampleService;
    @Autowired
    private SampleMapper sampleMapper;
    @Autowired
    private ShitMapper shitMapper;

    public Sample getById(Integer id) {
        return sampleMapper.getSampleById(id);
    }

    public void insertSample(Sample sample) {
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

    public void insertSampleBatch() {
        String[] strings = new String[]{"鞋子", " ", "水电费肯德基", "聚精会神了", "衣服", "速度爱爱", " ", "估计快了怕", "搜索啊",
                "，", "搜欧文", "去陪他", "驱蚊器哇阿", "根据诶人", "。", "阿斯蒂芬冷酷", "浩哥", "没收到", "没咋", " "};
        int length = strings.length;
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            List<Sample> list = new ArrayList<>();
            for (int j = 0; j < 10000; j++) {
                Sample sample = new Sample();
                int k = random.nextInt(length - 1);
                int b = random.nextInt(length - 1);
                int l = random.nextInt(length - 1);
                sample.setName(strings[k] + strings[b] + strings[l]);
                list.add(sample);
            }
            sampleMapper.insertBatch(list);
        }
    }
}