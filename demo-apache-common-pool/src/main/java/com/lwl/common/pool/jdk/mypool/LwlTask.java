package com.lwl.common.pool.jdk.mypool;

/**
 * author liuweilong
 * date 2019/8/19 14:58
 * desc
 */
public class LwlTask implements Runnable {


    /**
     * 任务队列
     */
    private final LwlRunnableQueue runnableQueue;

    /**
     * 标记
     */
    private volatile boolean running = true;

    public LwlTask(LwlRunnableQueue runnableQueue) {
        this.runnableQueue = runnableQueue;
    }


    @Override
    public void run() {

        //当前任务为running并且没有被中断，则不从队列获取下一个任务，
        while (running && !Thread.currentThread().isInterrupted()) {
            try {
                //获取任务
                Runnable task = runnableQueue.task();
                task.run();
            } catch (Exception e) {
                running = false;
                break;
            }
        }
    }

    //停止当前任务
    public void stop() {
        this.running = false;
    }
}
