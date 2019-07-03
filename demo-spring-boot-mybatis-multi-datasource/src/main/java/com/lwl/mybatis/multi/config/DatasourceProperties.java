package com.lwl.mybatis.multi.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author liuweilong
 * @description
 * @date 2019/7/2 15:21
 */
@Component
@ConfigurationProperties(prefix = "spring.datasource")
@Data
public class DatasourceProperties {
    private String masterUrl;
    private String masterUsername;
    private String masterPassword;
    private String driverClassName;
    private String slaveUrl;
    private String slaveUsername;
    private String slavePassword;
}
