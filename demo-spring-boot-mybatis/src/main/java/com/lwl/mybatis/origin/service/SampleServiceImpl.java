package com.lwl.mybatis.origin.service;

import com.lwl.mybatis.origin.entity.Sample;
import com.lwl.mybatis.origin.mapper.SampleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * author liuweilong
 * date 2019/12/27 2:58 下午
 * desc
 */
@Service
public class SampleServiceImpl implements SampleService{
    @Autowired
    private SampleMapper sampleMapper;

    @Override
    public Sample getById(Long id){
        return sampleMapper.findById(id);
    }

    /**
     * 试试debug事务
     * @param id
     * @return
     */
    @Override
    @Transactional
    public Sample updateAndGet(Long id){
        sampleMapper.updateById(id);
        return sampleMapper.findById(id);
    }
}
