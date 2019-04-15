package com.lwl.redisson.myauto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author lwl
 * @date 2019/4/15 11:12
 * @description
 */
@ConfigurationProperties(prefix = "lwl.redisson", ignoreUnknownFields = true)
@Data
public class LwlRedissonProperties {
    private int database = 1;
    private String address;
    private String password;
    private String clientName;
}