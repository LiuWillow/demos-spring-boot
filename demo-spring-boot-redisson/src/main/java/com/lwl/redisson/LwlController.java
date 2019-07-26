package com.lwl.redisson;

import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author lwl
 * @date 2019/4/15 11:23
 * @description
 */
@RestController
public class LwlController {
    @Autowired
    private RedissonClient redissonClient;
    @GetMapping("shit")
    public String set(){
        RBucket<Object> bucket = redissonClient.getBucket("simpleHa");
        bucket.set("lalalalaa", 30000, TimeUnit.MILLISECONDS);
        return "success";
    }

    @GetMapping("get")
    public String get(){
        RBucket<Object> bucket = redissonClient.getBucket("simpleHa");
        return (String) bucket.get();
    }
}