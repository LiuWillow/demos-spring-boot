package com.lwl.common.pool.jdk;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * @author liuweilong
 * @description
 * @date 2019/6/17 10:27
 */
public class ForkJoinTest {
    public static void main(String[] args) throws InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        PrintTask task = new PrintTask(1, 300);
        forkJoinPool.submit(task);
        forkJoinPool.awaitTermination(2, TimeUnit.SECONDS);
        forkJoinPool.shutdown();
    }

    static class PrintTask extends RecursiveAction{
        //最多打印50个数
        private static final int THRESHOLD = 50;
        private int start;
        private int end;

        public PrintTask(int start, int end){
            super();
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if (end - start < THRESHOLD){
                for (int i = start; i < end; i++) {
                    System.out.println(Thread.currentThread().getName() + "的i值为：" + i);
                }
            }else {
                int middle = (start + end) / 2;
                PrintTask left = new PrintTask(start, middle);
                PrintTask right = new PrintTask(middle, end);
                //并行执行两个小任务
                left.fork();
                right.fork();
            }
        }
    }
}
