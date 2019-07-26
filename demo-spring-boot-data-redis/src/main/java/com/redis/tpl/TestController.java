package com.redis.tpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuweilong
 * @description
 * @date 2019/5/29 17:00
 */
@RestController
public class TestController {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisUtils redisUtils;

    @GetMapping("/lalal")
    public void tset() {
        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        connection.set("la".getBytes(), "aa".getBytes(), Expiration.milliseconds(1000), RedisStringCommands.SetOption.SET_IF_ABSENT);
        if (!connection.isClosed()) {
            connection.close();
        }
        System.out.println();
    }

    @GetMapping("hash")
    public HashObject hash(String key, String name){
        HashObject hashObject = new HashObject();
        hashObject.setAge(11);
        hashObject.setId(111L);
        hashObject.setName(name);
        hashObject.setPassword("sdfsdfdf");
        redisUtils.hashSet(key, hashObject);
        return redisUtils.hashGet(key, HashObject.class);
    }
}
