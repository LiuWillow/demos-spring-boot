package com.lwl.mybatis.origin.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * author liuweilong
 * date 2019/12/27 3:25 下午
 * desc
 */
public class MyTaskProxy implements MethodInterceptor {

    /**
     *
     * @param object 被代理的对象
     * @param method 被代理的方法
     * @param args 方法参数
     * @param methodProxy 方法代理对象
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("执行之前");
        //因为基于继承，所以执行super方法
        methodProxy.invokeSuper(object, args);
        System.out.println("执行之后");
        return object;
    }
}
