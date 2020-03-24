package com.lwl.mybatis.origin.controller;

import com.lwl.mybatis.origin.service.SampleService;
import com.lwl.mybatis.origin.service.ShitService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * author liuweilong
 * date 2020/3/24 5:15 下午
 * desc
 */
@RestController
@RequestMapping("oom")
public class OOMController {
    @Resource
    private SampleService sampleService;
    @Resource
    private ShitService shitService;

    @GetMapping("sample")
    public String oomSample(){
        sampleService.tryOOM();
        return "success";
    }

    @GetMapping("shit")
    public String oomShit(){
        shitService.tryOOM();
        return "success";
    }

    @GetMapping("recur")
    public String oomRecur(){
        shitService.tryStackOverflow();
        return "success";
    }
}
