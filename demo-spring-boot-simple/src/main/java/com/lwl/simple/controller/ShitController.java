package com.lwl.simple.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author liuweilong
 * @date 2021/4/20
 * @description
 */
@RestController
@RequestMapping("shit")
@Slf4j
public class ShitController {
    @Data
    private static class Shit {
        private List<String> haha;
    }
    @PostMapping("sdf")
    public String shit(@RequestBody Shit shit) throws InterruptedException {
        log.info("进入sdf");
        TimeUnit.SECONDS.sleep(300);
        return "shit";
    }

    public static void main(String[] args) throws IOException {
        RestTemplate restTemplate = new RestTemplate();

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                List<String> list = new ArrayList<>();
                for (int j = 0; j < 3000; j++) {
                    StringBuilder str = new StringBuilder();
                    for (int k = 0; k < 10; k++) {
                        str.append(k);
                    }
                    list.add(str.toString());
                }
                Shit shit = new Shit();
                shit.setHaha(list);
                JSONObject postData = new JSONObject();
                postData.put("shit", shit);
                ResponseEntity<String> forEntity = restTemplate.postForEntity("http://localhost:9877/shit/sdf", postData, String.class);
            }).start();
        }
    }
}