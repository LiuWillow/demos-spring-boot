package com.lwl;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.concurrent.TimeUnit;

public class QuartzTest {
    public static void main(String[] args) throws SchedulerException, InterruptedException {
        SchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();

        JobDetail jobDetail1 = JobBuilder.newJob().ofType(TestTask1.class).withIdentity("job1", "group1")
                .build();
        JobDetail jobDetail2 = JobBuilder.newJob().ofType(TestTask2.class).withIdentity("job2", "group1")
                .build();
        CronTrigger trigger1 = TriggerBuilder.newTrigger().withIdentity("job1Trigger", "jobGroup1")
                .startNow().withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ? *")).build();

        CronTrigger trigger2 = TriggerBuilder.newTrigger().withIdentity("job2Trigger", "jobGroup2")
                .startNow().withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ? *")).build();

        scheduler.scheduleJob(jobDetail1, trigger1);
        scheduler.scheduleJob(jobDetail2, trigger2);
        TimeUnit.SECONDS.sleep(2);

        scheduler.start();
    }
}
