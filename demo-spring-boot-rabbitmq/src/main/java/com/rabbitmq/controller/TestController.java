package com.rabbitmq.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lwl
 * @date 2019/4/18 17:15
 * @description
 */
@RestController
@Slf4j
public class TestController {
    @Retryable(value = IllegalArgumentException.class, maxAttempts = 2)
    @GetMapping("ss")
    public String ss() {
        log.info("接口成功调用");
        throw new IllegalArgumentException();
    }
}