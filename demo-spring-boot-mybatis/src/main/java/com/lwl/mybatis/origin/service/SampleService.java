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
public interface SampleService {

    Sample getById(Long id);

    Sample updateAndGet(Long id);
}
