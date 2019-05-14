package com.lwl.zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.leader.LeaderLatch;
import org.apache.curator.retry.RetryNTimes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author liuweilong
 * @description
 * @date 2019/5/14 14:33
 * curator实现领导选举
 */
public class LeaderLatchExample {
    public static void main(String[] args) throws Exception {
        List<CuratorFramework> clients = new ArrayList();
        List<LeaderLatch> leaderLatches = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            CuratorFramework client = CuratorFrameworkFactory.newClient("119.3.210.17:2181", new RetryNTimes(1, 1000));
            clients.add(client);
            client.start();

            LeaderLatch leaderLatch = new LeaderLatch(client, "/LeaderLatch", "client#" + i);
            leaderLatches.add(leaderLatch);
            leaderLatch.start();
        }

        TimeUnit.SECONDS.sleep(2);

        for (LeaderLatch leaderLatch : leaderLatches) {
            if (leaderLatch.hasLeadership()){
                System.out.println("当前leader是" + leaderLatch.getId());
            }
        }

        for (CuratorFramework client : clients) {
            client.close();
        }

    }
}
