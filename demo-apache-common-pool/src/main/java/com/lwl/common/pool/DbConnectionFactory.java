package com.lwl.common.pool;

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;

/**
 * @author liuweilong
 * @description
 * @date 2019/6/6 15:04
 */
public class DbConnectionFactory implements PooledObjectFactory<DbConnection> {
    @Override
    public PooledObject<DbConnection> makeObject() throws Exception {
        DbConnection dbConnection = new DbConnection();
        //创建连接
        return new DefaultPooledObject<>(dbConnection);
    }

    @Override
    public void destroyObject(PooledObject<DbConnection> p) throws Exception {
        //断开连接
        p.getObject().setActive(false);
    }

    @Override
    public boolean validateObject(PooledObject<DbConnection> p) {
        //判断对象是否保持连接状态
        return p.getObject().getActive();
    }

    @Override
    public void activateObject(PooledObject<DbConnection> p) throws Exception {
        //激活连接
        p.getObject().setActive(true);
    }

    @Override
    public void passivateObject(PooledObject<DbConnection> p) throws Exception {
        //不管
    }
}
