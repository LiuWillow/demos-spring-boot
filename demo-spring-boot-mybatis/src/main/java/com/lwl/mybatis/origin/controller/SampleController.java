package com.lwl.mybatis.origin.controller;

import com.lwl.mybatis.origin.entity.Sample;
import com.lwl.mybatis.origin.mapper.SampleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author liuweilong
 * date 2019/12/24 6:56 下午
 * desc
 */
@RestController
@RequestMapping("/sample")
public class SampleController {
    @Autowired
    private SampleMapper sampleMapper;

    @GetMapping("{id}")
    public Sample getById(@PathVariable("id") Long id){
        return sampleMapper.findById(id);
    }
}