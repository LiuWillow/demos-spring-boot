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

//        scheduler.unscheduleJob(TriggerKey.triggerKey("trigger", "trigger1Group"));
//
//        JobDetail job3 = JobBuilder.newJob().withIdentity("job3", "job3Group").ofType(TestTask2.class).build();
//        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger3", "trigger3Group")
//                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(15))
//                .build();
//        scheduler.scheduleJob(job3, trigger);

        scheduler.start();
    }
}
