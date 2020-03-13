package com.lwl.mybatis.origin.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * author liuweilong
 * date 2020/03/11 23:17
 * desc
 */
//@Component
//@Aspect
@Order(100)
@Slf4j
public class TaskShieldByDomainAspect {
    @Value("#{'${domain}'.split(',')}")
    private Set<String> domains;

    @Pointcut("execution(public * com.lwl.mybatis.origin.service.SampleServiceImpl.*(..))")
    public void domainPointcut() {
    }
    @Pointcut("execution(public * com.lwl.mybatis.origin.service.ShitService.*(..))")
    public void pointcut2(){}

    @Pointcut("domainPointcut() || pointcut2()")
    public void finalCut(){}


    @Around("finalCut()")
    public Object handle(ProceedingJoinPoint joinPoint) throws Throwable {
        if (domains.contains(LoginInfoUtils.getDomain())) {
            return joinPoint.proceed(joinPoint.getArgs());
        }
        throw new IllegalArgumentException();
    }
}
