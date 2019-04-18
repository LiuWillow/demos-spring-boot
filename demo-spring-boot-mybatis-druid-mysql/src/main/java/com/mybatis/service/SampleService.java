package com.mybatis.service;

import com.mybatis.entity.Sample;
import com.mybatis.entity.Shit;

public interface SampleService {
    Sample getById(Integer id);
    void insertSample(Sample sample);
    void insertShit(Shit shit);
}