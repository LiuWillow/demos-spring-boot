package com.lwl.common.pool.jdk;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * @author liuweilong
 * @description
 * @date 2019/6/17 10:27
 */
public class ForkJoinTest {
    public static void main(String[] args) throws InterruptedException {
//        ForkJoinPool forkJoinPool = new ForkJoinPool();
//        int listSize = 300;
//        TmDataTransferTask task = new TmDataTransferTask(1, listSize);
//        forkJoinPool.submit(task);
    }

    static class TmDataTransferTask extends RecursiveAction{
        //最多打印50个数
        private static final int THRESHOLD = 30;
        private int start;
        private int end;

        public TmDataTransferTask(int start, int end){
            super();
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if (end - start < THRESHOLD){
                for (int i = start; i < end; i++) {

                }
            }else {
                int middle = (start + end) / 2;
                TmDataTransferTask left = new TmDataTransferTask(start, middle);
                TmDataTransferTask right = new TmDataTransferTask(middle, end);
                //并行执行两个小任务
                left.fork();
                right.fork();
            }
        }
    }
}
