package com.lwl.common.pool.jdk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liuweilong
 * @description
 * @date 2019/6/6 16:03
 */
public class FixedTest {
    public static void main(String[] args) {
        //核心线程和总线程一致，不会回收
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(() -> System.out.println("lll"));
    }
}
