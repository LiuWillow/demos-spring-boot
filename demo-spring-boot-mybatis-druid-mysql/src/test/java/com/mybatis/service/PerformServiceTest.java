package com.mybatis.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PerformServiceTest {
    @Autowired
    private PerformService performService;
    @Test
    public void testBatchInsert() throws ParseException {
        long begin = System.currentTimeMillis();
        performService.push();
        long end = System.currentTimeMillis();
        System.out.println("------------------总用时：" + ((end - begin) / 1000) + "秒------------------");
    }
}