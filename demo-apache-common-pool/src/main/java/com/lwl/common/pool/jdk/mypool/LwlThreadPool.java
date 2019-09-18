package com.lwl.common.pool.jdk.mypool;

/**
 * author liuweilong
 * date 2019/8/19 13:54
 * desc
 */
public interface LwlThreadPool {
    /**
     * 提交任务到线程池
     *
     * @param runnable
     */
    void execute(Runnable runnable);

    /**
     * 关闭线程池
     */
    void shutdown();

    /**
     * 初始化大小
     */
    int getInitSize();

    /**
     * 获取线程池最大线程数
     *
     * @return
     */
    int getMaxsize();

    /**
     * 获取线程池最大的线程数
     *
     * @return
     */
    int getCoreSize();

    /**
     * 获取线程池中用于缓存任务队列的大小
     *
     * @return
     */
    int getQuenSize();

    /**
     * 获取线程池中活跃线程的数量
     *
     * @return
     */
    int getActiveCount();

    /**
     * 查询线程池是否已经关闭
     *
     * @return
     */
    boolean isShutdown();
}
