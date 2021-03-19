package com.lwl;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author liuweilong
 * @date 2021/3/15
 * @description
 */
@Slf4j
public class TestTask1 implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("------------成功执行task1");
    }
}
