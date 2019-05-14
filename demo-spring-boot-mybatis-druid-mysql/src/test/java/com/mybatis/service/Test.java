package com.mybatis.service;
import com.mybatis.service.SampleService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Test {
    @Autowired
    private SampleService sampleService;

    @org.junit.Test
    public void insertBatch(){
        sampleService.insertSampleBatch();
    }

}
