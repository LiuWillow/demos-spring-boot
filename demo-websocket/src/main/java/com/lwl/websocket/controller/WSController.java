package com.lwl.websocket.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author liuweilong
 * date 2019/7/24 13:43
 * desc
 */
@RestController
public class WSController {
    @GetMapping("/test")
    public String test(){
        return "success";
    }
}
