package com.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@ComponentScan(basePackages="com.mybatis")
@MapperScan("com.mybatis.dao.mapper")
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class DemoSpringBootDruidMysqlApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoSpringBootDruidMysqlApplication.class, args);
    }
}