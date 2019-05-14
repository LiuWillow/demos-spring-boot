package com.lwl.zookeeper.zkclient;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * @author liuweilong
 * @description
 * @date 2019/5/14 11:53
 */
public class ZookeeperSourceClientTest {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper("119.3.210.17:2181", 5000, watchedEvent -> {
            System.out.println("连接的时候" + watchedEvent);
        });
        Stat stat = new Stat();
        //watcher可以监听lwl节点上的变化，并且只触发一次，以广播的形式发送变化消息
        byte[] data = zooKeeper.getData("/lwl", watchedEvent -> {
            Watcher.Event.EventType type = watchedEvent.getType();
            if (Watcher.Event.EventType.NodeDataChanged.equals(type)){
                System.out.println("监听到数据发生了改变");
            }
        }, stat);

        //创建节点
        zooKeeper.create("/lwl2", "1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);

        System.in.read();
    }
}
