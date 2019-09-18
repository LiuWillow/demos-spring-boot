package com.lwl.common.pool.jdk.mypool;


import java.util.LinkedList;

/**
 * author liuweilong
 * date 2019/8/19 14:14
 * desc
 */
public class DefaultRunnableQueue implements LwlRunnableQueue {
    /**
     * 队列最大长度
     */
    private final int limit;
    /**
     * 拒绝策略
     */
    private final DenyPolicy denyPolicy;
    /**
     * 存放任务
     */
    private final LinkedList<Runnable> runnableList = new LinkedList<>();

    /**
     * 线程池
     */
    private final LwlThreadPool threadPool;

    public DefaultRunnableQueue(int limit, DenyPolicy denyPolicy, LwlThreadPool threadPool) {
        this.limit = limit;
        this.denyPolicy = denyPolicy;
        this.threadPool = threadPool;
    }

    @Override
    public void offer(Runnable runnable) {
        synchronized (runnableList) {
            if (runnableList.size() >= limit) {
                //超过限制，启动拒绝策略
                this.denyPolicy.reject(runnable, threadPool);
            } else {
                //将入到队列
                runnableList.addLast(runnable);
                runnableList.notifyAll();
            }
        }
    }

    @Override
    public Runnable task() {
        synchronized (runnableList) {
            while (runnableList.isEmpty()) {
                try {
                    //如果没有任务进来，阻塞
                    runnableList.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            //从任务头移除一个任务
            return runnableList.removeFirst();
        }
    }

    @Override
    public int size() {
        //返回线程池数量
        synchronized (runnableList) {
            return runnableList.size();
        }
    }
}
