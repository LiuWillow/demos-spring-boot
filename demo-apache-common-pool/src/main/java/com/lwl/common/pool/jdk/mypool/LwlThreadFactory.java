package com.lwl.common.pool.jdk.mypool;

/**
 * author liuweilong
 * date 2019/8/19 15:00
 * desc
 */
public interface LwlThreadFactory {
    /**
     * 用于创建线程
     *
     * @param runnable
     * @return
     */
    Thread createThread(Runnable runnable);
}
