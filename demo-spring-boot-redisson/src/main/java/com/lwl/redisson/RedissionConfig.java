package com.lwl.redisson;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lwl
 * @date 2019/3/18 15:50
 * @description
 */
@Configuration
public class RedissionConfig {
    @Value("${redission.database}")
    private Integer database;
    /**
     * 必须是redis://host:port
     */
    @Value("${redission.address}")
    private String address;
    @Value("${redission.password}")
    private String password;
    @Bean
    public RedissonClient redissonClient(){
        Config config = new Config();
        SingleServerConfig singleServerConfig = config.useSingleServer();
        singleServerConfig.setClientName("redis14");
        singleServerConfig.setAddress(address);
        singleServerConfig.setDatabase(database);
        singleServerConfig.setPassword(password);
        //集群版本
//        ClusterServersConfig clusterServersConfig = config.useClusterServers();
//        clusterServersConfig.addNodeAddress("addr1").addNodeAddress("addr2");

        return Redisson.create(config);
    }
}