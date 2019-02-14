package com.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisUtilTest {
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void testGeo() {
        redisUtils.geo();
    }

    @Test
    public void test10000() {
        for (int i = 0; i < 100000; i++) {
            redisTemplate.opsForValue().set("lwl:test::key" + i, i + "");
        }
    }

    @Test
    public void testScan(){
        //scan用的高位加法遍历，因为怕扩容的时候高位的没有遍历到或者重复遍历
//        redisTemplate.getConnectionFactory().getConnection().scan()
    }
}