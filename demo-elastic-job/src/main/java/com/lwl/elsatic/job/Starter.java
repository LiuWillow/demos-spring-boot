package com.lwl.elsatic.job;

import org.apache.shardingsphere.elasticjob.api.JobConfiguration;
import org.apache.shardingsphere.elasticjob.lite.api.bootstrap.impl.ScheduleJobBootstrap;
import org.apache.shardingsphere.elasticjob.reg.base.CoordinatorRegistryCenter;
import org.apache.shardingsphere.elasticjob.reg.zookeeper.ZookeeperConfiguration;
import org.apache.shardingsphere.elasticjob.reg.zookeeper.ZookeeperRegistryCenter;

/**
 * @author liuweilong
 * @date 2021/3/22
 * @description
 */
public class Starter {
    public static void main(String[] args) {
        new ScheduleJobBootstrap(createRegistryCenter(), new Job1(), createJobConfiguration()).schedule();
    }

    private static CoordinatorRegistryCenter createRegistryCenter() {
        ZookeeperConfiguration config = new ZookeeperConfiguration("127.0.0.1:2181", "job1");
        config.setMaxRetries(3);
        CoordinatorRegistryCenter regCenter = new ZookeeperRegistryCenter(config);
        regCenter.init();
        return regCenter;
    }

    private static JobConfiguration createJobConfiguration() {
        return JobConfiguration.newBuilder("Job1", 3).cron("0/5 * * * * ?").build();
    }
}