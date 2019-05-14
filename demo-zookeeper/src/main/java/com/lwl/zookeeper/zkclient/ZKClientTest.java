package com.lwl.zookeeper.zkclient;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;

import java.io.IOException;

/**
 * @author liuweilong
 * @description
 * @date 2019/5/14 14:10
 */
public class ZKClientTest {
    public static void main(String[] args) throws IOException {
        //客户端的序列化机制要和服务端创建的节点的序列化机制一致，如果直接在服务器上创建节点，在此处会有序列化的错误
        ZkClient zkClient = new ZkClient("localhost:2081", 10000,  1000,
                new SerializableSerializer());
        zkClient.createPersistent("/data", "1".getBytes());
        zkClient.subscribeDataChanges("/data", new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
                System.out.println("数据被改了");
            }

            @Override
            public void handleDataDeleted(String s) throws Exception {

            }
        });

        System.in.read();
    }
}
