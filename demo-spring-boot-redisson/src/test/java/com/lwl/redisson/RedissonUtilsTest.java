package com.lwl.redisson;

import com.google.common.collect.ImmutableMultimap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RedissonUtilsTest {
    @Autowired
    private RedissonUtils redissonUtils;

    @Test
    public void testString(){
        redissonUtils.set("key1", "value1");
        redissonUtils.get("key1");
        redissonUtils.delete("key1");
    }

    @Test
    public void testLock() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(() ->{
                //客户端等两秒，锁十秒释放
                boolean success = redissonUtils.lock("lock", 2000, 10000);
                if (!success){
                    System.out.println("线程" + Thread.currentThread().getId() + "获取分布式锁失败");
                }else {
                    System.out.println("线程" + Thread.currentThread().getId() + "获取分布式锁成功");
                }
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
    }

    @Test
    public void testMap(){
        Map<Object, Object> hashMap = new HashMap<>();
        hashMap.put("name", "lwl");
        hashMap.put("age", 22);
        hashMap.put("sex", "男");

        redissonUtils.addMap("user", hashMap);
    }

    @Test
    public void testMGet(){
        redissonUtils.set("key1", "value1");
        redissonUtils.set("key2", "value2");
        redissonUtils.set("key3", "value3");
        Map<String, Object> map = redissonUtils.mGet("key1", "key2", "key3");
        for (Map.Entry<String, Object> stringObjectEntry : map.entrySet()) {
            System.out.println(stringObjectEntry.getValue());
        }
    }
}