package com.redis;

import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @author lwl
 * @date 2018/12/8 15:20
 * @description 默认lettuce
 */
@Service
public class RedisUtils {
    @Autowired
    private RedisTemplate redisTemplate;
    private static long LOCK_EXPIRE = 1000;

    public void setStringValue(String key, String value) {
        //如果不存在，就存进去
        redisTemplate.opsForValue().setIfAbsent(key, value);
    }

    /**
     * 获取分布式锁
     *
     * @param keyString
     * @return
     */
    public boolean lock(String keyString) {
        RedisConnection redisConnection = redisTemplate.getConnectionFactory().getConnection();
        long expireAt = System.currentTimeMillis() + LOCK_EXPIRE;
        byte[] key = keyString.getBytes();
        //nx+px原子操作
        Boolean acquire = redisConnection.set(key, String.valueOf(expireAt).getBytes(),
                Expiration.milliseconds(LOCK_EXPIRE), RedisStringCommands.SetOption.ifAbsent());

        if (acquire == null) {
            return false;
        }
        return acquire;
    }


    public void geo() {
        //添加，geo本质是用zset，将经纬度映射到一维，作为score
        redisTemplate.opsForGeo().add("company", new Point(112.2, 34.4), "小米");
        redisTemplate.opsForGeo().add("company", new ImmutableMap.Builder<String, Point>()
                .put("华为", new Point(123.21, 33.3))
                .put("中非", new Point(118.21, 31.3))
                .put("阿里", new Point(126.21, 38.3))
                .put("京东", new Point(122.21, 36.3))
                .build());
        //获取经纬度
        System.out.println(Arrays.toString(redisTemplate.opsForGeo().position("company", "华为", "京东").toArray()));
        GeoResults<RedisGeoCommands.GeoLocation<String>> results = redisTemplate.opsForGeo().radius("company", "华为", new Distance(100));
    }
}