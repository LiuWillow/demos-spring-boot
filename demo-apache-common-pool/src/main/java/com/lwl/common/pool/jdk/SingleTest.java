package com.lwl.common.pool.jdk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liuweilong
 * @description
 * @date 2019/6/6 16:13
 */
public class SingleTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> System.out.println("jsjsj"));
    }
}
