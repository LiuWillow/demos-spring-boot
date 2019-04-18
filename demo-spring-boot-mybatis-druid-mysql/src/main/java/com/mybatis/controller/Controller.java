package com.mybatis.controller;

import com.mybatis.entity.Sample;
import com.mybatis.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private SampleService sampleService;

    @GetMapping("/{id}")
    public Sample login(@PathVariable("id") Integer id){
        return sampleService.getById(id);
    }

    @GetMapping("/insert")
    public void insert(Sample sample){
        sampleService.insertSample(sample);
    }

}