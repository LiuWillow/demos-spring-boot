package com.lwl.common.pool.generic;

import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/**
 * @author liuweilong
 * @description
 * @date 2019/6/6 15:06
 */
public class GenericObjectPoolTest {
    public static void main(String[] args) {
        DbConnectionFactory factory = new DbConnectionFactory();
        //对象池参数
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxIdle(20);
        poolConfig.setMaxTotal(100);
        poolConfig.setMinIdle(5);

        //创建一个对象池，传入配置和工厂
        GenericObjectPool<DbConnection> objectPool = new GenericObjectPool<>(factory, poolConfig);
        for (int i = 0; i < 100; i++) {
            DbConnection dbConnection = null;
            try {
                //从对象池获取对象
                dbConnection = objectPool.borrowObject();
                System.out.println(dbConnection.getActive());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (dbConnection != null) {
                    //返还对象
                    objectPool.returnObject(dbConnection);
                }
            }
        }

    }
}
