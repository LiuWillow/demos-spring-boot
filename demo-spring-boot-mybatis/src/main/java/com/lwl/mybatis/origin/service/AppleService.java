package com.lwl.mybatis.origin.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class AppleService {
//    @Resource
//    private BananaService bananaService;

    @Transactional
    public void aaa() {
        System.out.println("sdf");
    }
}
