package com.lwl.mybatis.origin;

import org.springframework.transaction.support.TransactionSynchronization;

/**
 * author liuweilong
 * date 2020/3/9 7:18 下午
 * desc
 */
public class MySynchronization implements TransactionSynchronization {
    @Override
    public void afterCommit() {
        System.out.println("after commit");
    }
}
