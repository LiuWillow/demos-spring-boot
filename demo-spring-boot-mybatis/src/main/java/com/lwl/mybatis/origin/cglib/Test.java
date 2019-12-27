package com.lwl.mybatis.origin.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * author liuweilong
 * date 2019/12/27 4:48 下午
 * desc
 */
public class Test {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(MyTask.class);
        enhancer.setCallback(new MyTaskProxy());
        MyTask myTask = (MyTask) enhancer.create();
        myTask.run();
    }
}
