package com.lwl.common.pool.key;

import org.apache.commons.pool2.KeyedPooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

/**
 * @author liuweilong
 * @description
 * @date 2019/6/6 15:17
 */
public class DbConnectioNKeyFactory implements KeyedPooledObjectFactory<String, KeyDbConnection> {
    @Override
    public PooledObject<KeyDbConnection> makeObject(String key) throws Exception {
        KeyDbConnection dbConnection = new KeyDbConnection();
        dbConnection.setUrl(key);
        dbConnection.setActive(true);
        return new DefaultPooledObject<>(dbConnection);
    }

    @Override
    public void destroyObject(String key, PooledObject<KeyDbConnection> p) throws Exception {
        p.getObject().setActive(false);
    }

    @Override
    public boolean validateObject(String key, PooledObject<KeyDbConnection> p) {
        p.getObject().setActive(true);
        return false;
    }

    @Override
    public void activateObject(String key, PooledObject<KeyDbConnection> p) throws Exception {
        p.getObject().setActive(true);
    }

    @Override
    public void passivateObject(String key, PooledObject<KeyDbConnection> p) throws Exception {

    }
}
