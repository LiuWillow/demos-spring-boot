package com.lwl.common.pool.jdk.mypool;

/**
 * author liuweilong
 * date 2019/8/19 14:10
 * desc
 */
public interface LwlRunnableQueue {
    /**
     * 当有新的任务进来时，放到队列的末尾
     *
     * @param offer
     */
    void offer(Runnable offer);

    /**
     * 工作线程通过task获取任务
     *
     * @return
     */
    Runnable task();

    /**
     * 获取线程池缓存任务的数量
     *
     * @return
     */
    int size();
}
