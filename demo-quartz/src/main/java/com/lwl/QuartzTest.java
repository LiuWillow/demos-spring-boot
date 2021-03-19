package com.lwl;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author liuweilong
 * @date 2021/3/15
 * @description
 */
public class QuartzTest {
    public static void main(String[] args) throws SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
//
//        JobDetail job1 = JobBuilder.newJob().withIdentity("job1", "job1Group").ofType(TestTask1.class).build();
//        JobDetail job2 = JobBuilder.newJob().withIdentity("job2", "job2Group").ofType(TestTask2.class).build();
//
//        Trigger trigger1 = TriggerBuilder.newTrigger().withIdentity("trigger1", "trigger1Group")
//                .withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ? *"))
//                .build();
//        Trigger trigger2 = TriggerBuilder.newTrigger().withIdentity("trigger2", "trigger2Group")
//                .withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ? *"))
//                .build();
//
//        scheduler.scheduleJob(job1, trigger1);
//        scheduler.scheduleJob(job2, trigger2);

        scheduler.start();
    }
}
