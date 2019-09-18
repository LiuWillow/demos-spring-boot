package com.lwl.common.pool.jdk.mypool;

/**
 * author liuweilong
 * date 2019/8/19 14:57
 * desc
 */
public interface DenyPolicy {



    void reject(Runnable runnable, LwlThreadPool threadPool);

    /**
     * 直接丢弃任务
     */
    class DiscardDenyPolicy implements DenyPolicy {

        @Override
        public void reject(Runnable runnable, LwlThreadPool threadPool) {
            //TODO
        }
    }

    /**
     * 该拒绝策略会向任务提交者抛出异常
     */
    class AbortDenyPolicy implements DenyPolicy {

        @Override
        public void reject(Runnable runnable, LwlThreadPool threadPool) {
            throw new RunnableDenyPolicyException("");
        }
    }

    //该拒绝策略会使任务在提交者所在的线程执行
    class RunnerDenyPolicy implements DenyPolicy {

        @Override
        public void reject(Runnable runnable, LwlThreadPool threadPool) {
            if (!threadPool.isShutdown()) {
                runnable.run();
            }
        }
    }
}
