package com.lwl.mybatis.multi.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuweilong
 * @description
 * @date 2019/7/2 15:05
 */
@Configuration

public class DatasourceConfig {
    @Autowired
    private DatasourceProperties properties;

    public DataSource master() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(properties.getMasterUrl());
        dataSource.setUsername(properties.getMasterUsername());
        dataSource.setPassword(properties.getMasterPassword());
        dataSource.setDriverClassName(properties.getDriverClassName());
        return dataSource;
    }

    public DataSource slave() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(properties.getSlaveUrl());
        dataSource.setUsername(properties.getSlaveUsername());
        dataSource.setPassword(properties.getSlavePassword());
        dataSource.setDriverClassName(properties.getDriverClassName());
        return dataSource;
    }

    @Bean
    public DynamicDataSource dynamicDataSource() {
        Map<Object, Object> targetDataSources = new HashMap<>(4);
        DataSource master = master();
        targetDataSources.put(DynamicDataSource.DataSourceType.MASTER, master);
        DataSource slave = slave();
        targetDataSources.put(DynamicDataSource.DataSourceType.SLAVE, slave);

        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setTargetDataSources(targetDataSources);
        dynamicDataSource.setDefaultTargetDataSource(master);
        return dynamicDataSource;
    }

}
