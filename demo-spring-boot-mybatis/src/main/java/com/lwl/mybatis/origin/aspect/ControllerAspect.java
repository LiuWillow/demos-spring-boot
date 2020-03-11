package com.lwl.mybatis.origin.aspect;

import com.lwl.mybatis.origin.entity.Request;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * author liuweilong
 * date 2020/03/11 23:17
 * desc
 */
@Component
@Aspect
@Slf4j
public class ControllerAspect {
    @Pointcut("execution(public * com.lwl.mybatis.origin.controller.*.*(..))")
    public void controllerPointcut() {
    }

    @Around("controllerPointcut()")
    public Object handle(ProceedingJoinPoint joinPoint) throws Throwable{
        try {
            Request<?> request = null;
            Object[] args = joinPoint.getArgs();
            for (Object arg : args) {
                if (arg instanceof Request) {
                    request = (Request<?>) arg;
                    break;
                }
            }
            if (Objects.nonNull(request)) {
                LoginInfoUtils.setDomain(request.getDomain());
            }
            return joinPoint.proceed(joinPoint.getArgs());
        } finally {
            LoginInfoUtils.release();
        }
    }

}
