package com.lwl.redisson.myauto;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lwl
 * @date 2019/4/15 11:11
 * @description
 */
@Configuration
@ConditionalOnClass({RedissonClient.class, SingleServerConfig.class})
@EnableConfigurationProperties(LwlRedissonProperties.class)
public class RedissonAutoConfiguration {
    @Autowired
    private LwlRedissonProperties properties;
    @Bean
    public RedissonClient redissonClient(){
        Config config = new Config();
        SingleServerConfig singleServerConfig = config.useSingleServer();
        singleServerConfig.setClientName(properties.getClientName());
        singleServerConfig.setAddress(properties.getAddress());
        singleServerConfig.setDatabase(properties.getDatabase());
        singleServerConfig.setPassword(properties.getPassword());
        return Redisson.create(config);
    }
}