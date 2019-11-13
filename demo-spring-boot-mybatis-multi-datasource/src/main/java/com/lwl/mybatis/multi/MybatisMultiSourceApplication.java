package com.lwl.mybatis.multi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liuweilong
 * @description
 * @date 2019/7/2 14:50
 */
@SpringBootApplication
public class MybatisMultiSourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisMultiSourceApplication.class, args);
    }
}
