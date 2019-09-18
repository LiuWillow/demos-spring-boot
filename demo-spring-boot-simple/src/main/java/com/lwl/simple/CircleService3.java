package com.lwl.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author liuweilong
 * date 2019/9/4 11:46
 * desc
 */
@Service
public class CircleService3 {
    @Autowired
    private CircleService1 circleService1;
}
