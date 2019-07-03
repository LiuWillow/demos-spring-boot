package com.lwl.mybatis.multi.aop;

import com.lwl.mybatis.multi.config.DynamicDataSource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author liuweilong
 * @description
 * @date 2019/7/2 15:31
 */
@Aspect
@Component
public class DataSourceAspect {
    @Pointcut("@annotation(com.lwl.mybatis.multi.aop.Master)")
    public void masterPointCut() {
    }

    @Pointcut("@annotation(com.lwl.mybatis.multi.aop.Slave)")
    public void slavePointCut() {
    }

    @Before("masterPointCut()")
    public void master() {
        DynamicDataSource.setMaster();
        System.out.println("切换为master");
    }

    @Before("slavePointCut()")
    public void slave() {
        DynamicDataSource.setSlave();
        System.out.println("切换为slave");
    }
}
