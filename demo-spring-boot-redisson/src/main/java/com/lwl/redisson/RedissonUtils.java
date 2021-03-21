package com.lwl.redisson;

import org.redisson.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author lwl
 * @date 2019/3/18 15:22
 * @description
 */
@Service
public class RedissonUtils {
    @Autowired
    private RedissonClient redissonClient;

    /**
     * 设置string，不过期
     *
     * @param key
     * @param value
     */
    public void set(String key, Object value) throws InterruptedException {
        RLock shit = redissonClient.getFairLock("shit");
        shit.tryLock(111L, TimeUnit.SECONDS);
        RBucket<Object> bucket = redissonClient.getBucket(key);
        bucket.set(value);
    }

    /**
     * 设置string，设置过期时间，默认毫秒
     *
     * @param key
     * @param value
     * @param expire
     */
    public void set(String key, Object value, long expire) {
        RBucket<Object> bucket = redissonClient.getBucket(key);
        bucket.set(value, expire, TimeUnit.MILLISECONDS);
    }

    public Object get(String key) {
        RBucket<Object> bucket = redissonClient.getBucket(key);
        return bucket.get();
    }

    public void delete(String key) {
        RBucket<Object> bucket = redissonClient.getBucket(key);
        bucket.delete();
    }

    /**
     * 用RedLock获取分布式锁，设置客户端等待时间和锁过期时间
     *
     * @param key
     * @param wait
     * @param expire
     * @return
     */
    public boolean lock(String key, long wait, long expire) {
        RLock rLock = redissonClient.getLock(key);
        if (rLock.isLocked()) {
            return false;
        }
        try {
            return rLock.tryLock(wait, expire, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 释放锁
     *
     * @param key
     * @return
     */
    public boolean releaseLock(String key) {
        RLock lock = redissonClient.getLock(key);
        lock.unlock();
        return true;
    }

    /**
     * 操作hash
     *
     * @param key
     * @param valueMap
     */
    public void addMap(String key, Map<Object, Object> valueMap) {
        RMap<Object, Object> map = redissonClient.getMap(key);
        map.putAll(valueMap);
    }

    public Object getMap(String mapName, String key) {
        RMap<Object, Object> map = redissonClient.getMap(mapName);
        return map.get(key);
    }

    /**
     * 复杂度O（n），尽量不用
     *
     * @param keys
     * @return
     */
    public Map<String, Object> mGet(String... keys) {
        return redissonClient.getBuckets().get(keys);
    }

    /**
     * 管道批量操作
     * @param keys
     */
    public void piplineDelete(String... keys) {
        RBatch rBatch = redissonClient.createBatch(BatchOptions.defaults());
        for (String key : keys) {
            rBatch.getBucket(key).deleteAsync();
        }
        rBatch.execute();
    }
}