package com.lwl.zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.Watcher;

/**
 * @author liuweilong
 * @description
 * @date 2019/5/14 14:17
 */
public class CuratorClientTest {
    public static void main(String[] args) throws Exception {
        CuratorFramework client = CuratorFrameworkFactory.newClient("119.3.210.17:2181",
                new RetryNTimes(3, 1000));
        client.start();
        client.create().withMode(CreateMode.EPHEMERAL).forPath("/curator", "3".getBytes());

        String path = "/curator";
        //是对节点内容的缓存
        NodeCache nodeCache = new NodeCache(client, path);
        //监听的是缓存中的数据和节点中的数据的区别
        // 指定为true，表示start的时候去获取节点数据，这样初始化的时候就不会触发监听器
        nodeCache.start(true);

        //curator可以解决只能监听一次的问题
        nodeCache.getListenable().addListener(() -> System.out.println("监听到了"));

        client.getData().usingWatcher((Watcher) watchedEvent -> System.out.println("用的是原生watch，一次性的")).forPath(path);

        System.in.read();

    }
}
