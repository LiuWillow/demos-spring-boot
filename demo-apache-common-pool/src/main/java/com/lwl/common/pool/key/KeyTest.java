package com.lwl.common.pool.key;

import org.apache.commons.pool2.impl.GenericKeyedObjectPool;
import org.apache.commons.pool2.impl.GenericKeyedObjectPoolConfig;

/**
 * @author liuweilong
 * @description
 * @date 2019/6/6 15:23
 */
public class KeyTest {
    public static void main(String[] args) {
        GenericKeyedObjectPoolConfig poolConfig = new GenericKeyedObjectPoolConfig();
        poolConfig.setMaxIdlePerKey(10);
        poolConfig.setMaxTotalPerKey(100);
        poolConfig.setMaxTotal(500);
        poolConfig.setMinIdlePerKey(10);

        DbConnectioNKeyFactory factory = new DbConnectioNKeyFactory();
        GenericKeyedObjectPool<String, KeyDbConnection> objectPool = new GenericKeyedObjectPool<>(factory, poolConfig);
        KeyDbConnection connection1 = null;
        KeyDbConnection connection2 = null;

        try {
            connection1 = objectPool.borrowObject("192.168.10.111");
            connection2 = objectPool.borrowObject("192.168.10.112");
            System.out.println(connection1.getUrl());
            System.out.println(connection2.getUrl());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection1 != null){
                objectPool.returnObject(connection1.getUrl(), connection1);
            }
            if (connection2 != null){
                objectPool.returnObject(connection2.getUrl(), connection2);
            }
        }

    }
}
