package com.lwl.common.pool.jdk.mypool;

/**
 * author liuweilong
 * date 2019/8/19 14:57
 * desc
 */
public class RunnableDenyPolicyException extends RuntimeException{
    public RunnableDenyPolicyException(String message) {
        super(message);
    }
}
