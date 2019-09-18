package com.lwl.common.pool.jdk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author liuweilong
 * @description
 * @date 2019/6/6 16:07
 */
public class ScheduledTest {
    public static void main(String[] args) {
        //比timer更强大，更安全
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        executorService.schedule(() -> System.out.println("又过了三秒"), 3, TimeUnit.SECONDS);

    }
}
