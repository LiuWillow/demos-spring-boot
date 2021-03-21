package com.lwl.mybatis.origin.controller;

import com.lwl.mybatis.origin.entity.Request;
import com.lwl.mybatis.origin.entity.Sample;
import com.lwl.mybatis.origin.mapper.SampleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * author liuweilong
 * date 2019/12/24 6:56 下午
 * desc
 */
@RestController
@RequestMapping("/sample")
public class SampleController {
    @Resource
    private SampleMapper sampleMapper;


    @GetMapping("{id}")
    public Sample updateAndGet(@PathVariable("id") Long id){
        if (id == null) {
            id = 1L;
        }
        return sampleMapper.findById(id);
    }
}