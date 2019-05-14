package com.lwl.zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.leader.LeaderLatch;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListener;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.retry.RetryNTimes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author liuweilong
 * @description
 * @date 2019/5/14 14:41
 */
public class LeaderSelectorExample {
    public static void main(String[] args) throws Exception {
        List<CuratorFramework> clients = new ArrayList();
        List<LeaderSelector> leaderSelectors = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            CuratorFramework client = CuratorFrameworkFactory.newClient("119.3.210.17:2181", new RetryNTimes(1, 1000));
            clients.add(client);
            client.start();

            LeaderSelector leaderSelector = new LeaderSelector(client, "/LeaderSelector", new LeaderSelectorListener() {
                @Override
                public void takeLeadership(CuratorFramework client) throws Exception {
                    //当上了Leader就会进入这个方法
                    System.out.println("当前leader是" + client);
                    TimeUnit.SECONDS.sleep(5);
                }

                @Override
                public void stateChanged(CuratorFramework client, ConnectionState newState) {

                }
            });

            leaderSelector.start();
            leaderSelectors.add(leaderSelector);
        }
        System.in.read();

        for (LeaderSelector selector : leaderSelectors) {
            selector.close();
        }

        for (CuratorFramework client : clients) {
            client.close();
        }

    }
}
