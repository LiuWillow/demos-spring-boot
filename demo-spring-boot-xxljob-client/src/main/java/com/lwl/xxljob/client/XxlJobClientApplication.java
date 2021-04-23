package com.lwl.xxljob.client;

import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * author liuweilong
 * date 2020/1/6 4:39 下午
 * desc
 */
@SpringBootApplication
@RestController
public class XxlJobClientApplication {
    public static void main(String[] args) {

        SpringApplication.run(XxlJobClientApplication.class, args);
    }

    @GetMapping("ss")
    public void shit() {

    }

    @Data
    public class Test {
        private Long id;
        private Integer status;
        private Date triggerTime;
    }
}