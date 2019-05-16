package com.lwl.simple;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author liuweilong
 * @description
 * @date 2019/5/16 16:53
 */
@Service
public class AsyncService {
    @Async
    public void asyncMethod() throws InterruptedException {
        System.out.println("开始执行异步方法");
        TimeUnit.SECONDS.sleep(5);
        System.out.println("异步方法执行完毕");
    }
}
