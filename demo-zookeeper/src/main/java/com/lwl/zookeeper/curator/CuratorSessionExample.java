package com.lwl.zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.framework.state.ConnectionStateListener;
import org.apache.curator.retry.RetryNTimes;

/**
 * @author liuweilong
 * @description
 * @date 2019/5/14 14:29
 */
public class CuratorSessionExample {
    public static void main(String[] args) {
        CuratorFramework client = CuratorFrameworkFactory.newClient("119.3.210.17:2181", 1000, 1000,
                new RetryNTimes(1, 1000));

        client.start();

        client.getConnectionStateListenable().addListener(new ConnectionStateListener() {
            @Override
            public void stateChanged(CuratorFramework client, ConnectionState newState) {
                if (newState == ConnectionState.LOST){
                    try {
                        if (client.getZookeeperClient().blockUntilConnectedOrTimedOut()){
                            //如果网络连接断开了，执行这里的操作
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


    }
}
