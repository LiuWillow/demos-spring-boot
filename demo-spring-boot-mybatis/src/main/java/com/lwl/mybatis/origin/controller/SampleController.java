package com.lwl.mybatis.origin.controller;

import com.lwl.mybatis.origin.entity.Request;
import com.lwl.mybatis.origin.entity.Sample;
import com.lwl.mybatis.origin.service.SampleService;
import com.lwl.mybatis.origin.service.SampleServiceImpl;
import com.lwl.mybatis.origin.service.ShitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * author liuweilong
 * date 2019/12/24 6:56 下午
 * desc
 */
@RestController
@RequestMapping("/sample")
public class SampleController {
    @Autowired
    private SampleService sampleService;
    @Resource
    private SampleServiceImpl sampleService1;
    @Resource
    private ShitService shitService;



    @GetMapping("{id}")
    public Sample updateAndGet(@PathVariable("id") Long id){
        return sampleService.updateAndGet(id);
    }

    @GetMapping("test/sample")
    public void testSample(Request<?> request){
        sampleService1.sample();
    }

    @GetMapping("test/shit")
    public void testShit(Request<?> request){
        shitService.haha();
    }

    @GetMapping("oom")
    public void oom(){
        List<Sample> list = new ArrayList<>();
        for (int i = 0; i < 1000000000; i++) {
            Sample sample = new Sample();
            sample.setAge(1);
            list.add(sample);
        }
        System.out.println(list);
    }
}