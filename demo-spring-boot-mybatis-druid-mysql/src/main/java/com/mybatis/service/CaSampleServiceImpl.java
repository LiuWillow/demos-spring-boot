package com.mybatis.service;

import com.mybatis.dao.mapper.CaSampleMapper;
import com.mybatis.entity.CaSample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaSampleServiceImpl implements CaSampleService {
    @Autowired
    private CaSampleMapper caSampleMapper;

    @Override
    public CaSample getById(Integer id) {
        return caSampleMapper.getSampleById(id);
    }
}