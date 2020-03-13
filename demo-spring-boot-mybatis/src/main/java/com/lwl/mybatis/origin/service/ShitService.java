package com.lwl.mybatis.origin.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * author liuweilong
 * date 2020/3/11 11:36 下午
 * desc
 */
@Service
public class ShitService {
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void haha(){
        System.out.println("hah");
    }
}
