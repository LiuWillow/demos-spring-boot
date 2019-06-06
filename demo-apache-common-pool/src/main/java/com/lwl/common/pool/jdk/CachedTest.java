package com.lwl.common.pool.jdk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liuweilong
 * @description
 * @date 2019/6/6 15:59
 */
public class CachedTest {
    public static void main(String[] args) {
        //缓存线程池，核心线程数0，最大线程数为int最大值，最大空闲时间60秒，超过60 秒则回收
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> System.out.println("lalsl"));
    }
}
