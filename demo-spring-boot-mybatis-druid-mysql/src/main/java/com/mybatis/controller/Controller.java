package com.mybatis.controller;

import com.mybatis.entity.CaSample;
import com.mybatis.service.CaSampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private CaSampleService caSampleService;

    @GetMapping("/{id}")
    public CaSample login(@PathVariable("id") Integer id){
        return caSampleService.getById(id);
    }
}