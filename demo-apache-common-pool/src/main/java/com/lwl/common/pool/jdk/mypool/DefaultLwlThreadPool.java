package com.lwl.common.pool.jdk.mypool;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * author liuweilong
 * date 2019/8/19 13:54
 * desc
 */
public class DefaultLwlThreadPool extends Thread implements LwlThreadPool {


    /**
     * 初始化线程数量
     */
    private final int initSize;

    /**
     * 线程池最大线程数量
     */
    private final int maxSize;

    /**
     * 线程池核心线程数量
     */
    private final int coreSize;

    /**
     * 当前活跃的线程数量
     */
    private int activeCount;

    /**
     * 线程工厂
     */
    private final LwlThreadFactory threadFactory;

    /**
     * 任务队列
     */
    private final LwlRunnableQueue runnableQueue;
    /**
     * 是否停止线程池
     */
    private volatile boolean isShutdown = false;

    /**
     * 时间
     */
    private final long keepAliveTime;
    /**
     * 睡眠工具类
     */
    private final TimeUnit timeUnit;

    /**
     * 任务队列
     */
    private final Queue<ThreadTask> threadQueue = new ArrayDeque();

    private final static DenyPolicy DEFAULT_DENY_POLICY = new DenyPolicy.DiscardDenyPolicy();

    private final static LwlThreadFactory DEFAULT_THREAD_FACTORY = new DefaultThreadFactory();

    public DefaultLwlThreadPool(int initSize, int maxSize, int coreSize, int queueSize) {
        this(initSize, maxSize, coreSize, DEFAULT_THREAD_FACTORY, queueSize, DEFAULT_DENY_POLICY, 10, TimeUnit.SECONDS);
    }

    public DefaultLwlThreadPool(int initSize, int maxSize, int coreSize, LwlThreadFactory defaultThreadFactory,
                           int queueSize, DenyPolicy defaultDenyPolicy, int keepAliveTime, TimeUnit timeUnit) {
        this.initSize = initSize;
        this.maxSize = maxSize;
        this.coreSize = coreSize;
        this.threadFactory = defaultThreadFactory;
        this.runnableQueue = new DefaultRunnableQueue(queueSize, defaultDenyPolicy, this);
        this.keepAliveTime = keepAliveTime;
        this.timeUnit = timeUnit;
        this.init();
    }

    /**
     * 初始化
     */
    private void init() {
        start();
        for (int i = 0; i < initSize; i++) {
            newThread();
        }
    }

    /**
     * 扩容
     */
    private void newThread() {
        LwlTask internalTask = new LwlTask(runnableQueue);
        Thread thread = this.threadFactory.createThread(internalTask);
        ThreadTask threadTask = new ThreadTask(thread, internalTask);
        threadQueue.offer(threadTask);
        this.activeCount++;
        thread.start();
    }

    private void removeThread() {
        //从线程中移除某个线程
        ThreadTask threadTask = threadQueue.remove();
        threadTask.internalTask.stop();
        this.activeCount--;
    }

    @Override
    public void run() {
        //用于维护线程数量，比如扩容、回收等工作
        while (!isShutdown && !isInterrupted()) {
            try {
                timeUnit.sleep(keepAliveTime);
            } catch (InterruptedException e) {
                isShutdown = true;
                break;
            }

            synchronized (this) {
                if (isShutdown)
                    break;
                if (runnableQueue.size() > 0 && activeCount < coreSize) {
                    for (int i = initSize; i < coreSize; i++) {
                        newThread();
                    }
                    continue;
                }


                if (runnableQueue.size() > 0 && activeCount < coreSize) {
                    for (int i = initSize; i < maxSize; i++) {
                        newThread();
                    }
                }

                if (runnableQueue.size() == 0 && activeCount > coreSize) {
                    for (int i = coreSize; i < activeCount; i++) {
                        removeThread();
                    }
                }


            }
        }
    }

    @Override
    public void execute(Runnable runnable) {
        if (this.isShutdown)
            throw new IllegalStateException("The thread pool is destroy");
        //提交到队列
        this.runnableQueue.offer(runnable);
    }

    @Override
    public void shutdown() {
        synchronized (this) {
            if (isShutdown) {
                return;
            }
            isShutdown = true;

            threadQueue.forEach(threadTask -> {
                threadTask.internalTask.stop();
                threadTask.thread.interrupt();
            });
            this.interrupt();
        }
    }

    @Override
    public int getInitSize() {
        if (isShutdown)
            throw new IllegalStateException("The thread pool is destroy");
        return this.initSize;
    }

    @Override
    public int getMaxsize() {
        if (isShutdown)
            throw new IllegalStateException("The thread pool is destroy");
        return this.maxSize;
    }

    @Override
    public int getCoreSize() {
        if (isShutdown)
            throw new IllegalStateException("The thread pool is destroy");
        return this.coreSize;
    }

    @Override
    public int getQuenSize() {
        if (isShutdown)
            throw new IllegalStateException("The thread pool is destroy");
        return this.runnableQueue.size();
    }

    @Override
    public int getActiveCount() {
        if (isShutdown)
            throw new IllegalStateException("The thread pool is destroy");
        return this.activeCount;
    }

    @Override
    public boolean isShutdown() {
        if (isShutdown)
            throw new IllegalStateException("The thread pool is destroy");
        return this.isShutdown;
    }

    /**
     * ThreadTask只是InternalTask和Thread结合
     */
    private static class ThreadTask {
        Thread thread;
        LwlTask internalTask;

        public ThreadTask(Thread thread, LwlTask internalTask) {
            this.thread = thread;
            this.internalTask = internalTask;
        }
    }


    /**
     * 默认线程池
     */
    private static class DefaultThreadFactory implements LwlThreadFactory {

        private static final AtomicInteger GROUP_COUNTER = new AtomicInteger(1);

        private static final ThreadGroup group = new ThreadGroup("MyThreadPool-" + GROUP_COUNTER.getAndDecrement());

        private static final AtomicInteger COUNTER = new AtomicInteger(0);

        @Override
        public Thread createThread(Runnable runnable) {
            return new Thread(group, runnable, "thread-pool-" + COUNTER.getAndDecrement());
        }
    }
}
