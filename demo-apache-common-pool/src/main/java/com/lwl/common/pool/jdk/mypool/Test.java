package com.lwl.common.pool.jdk.mypool;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author liuweilong
 * date 2019/8/19 15:03
 * desc
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
//        LwlThreadPool lwlThreadPool = new DefaultLwlThreadPool(5, 8, 5, 100);
//        for (int i = 0; i < 100; i++) {
//            lwlThreadPool.execute(() -> System.out.println(Thread.currentThread().getName() + Thread.currentThread().getId()));
//        }

//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 2000,
//                TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(10));
//        for (int i = 0; i < 1000; i++) {
//            threadPoolExecutor.execute(() -> {
//                try {
//                    TimeUnit.SECONDS.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName() + Thread.currentThread().getId());
//            });
//        }
        ReentrantLock lock = new ReentrantLock(true);
        lock.lock();
        lock.lock();
        lock.tryLock();
        lock.tryLock();
        lock.unlock();
    }
}
