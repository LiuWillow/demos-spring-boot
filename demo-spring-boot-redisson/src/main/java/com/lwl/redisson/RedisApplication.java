package com.lwl.redisson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.lwl.redisson")
public class RedisApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context= SpringApplication.run(RedisApplication.class, args);
        ServerProperties bean = context.getBean(ServerProperties.class);
        System.out.println(bean.getPort());
    }
}