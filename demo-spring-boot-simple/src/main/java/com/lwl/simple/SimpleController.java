package com.lwl.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lwl
 * @date 2019/4/18 9:42
 * @description
 */
@RestController
public class SimpleController {
    @Autowired
    private AsyncService asyncService;

    @GetMapping("/simple")
    public String hah(){
        return "hah";
    }

    @GetMapping("/async")
    public String asyncController() throws InterruptedException {
        asyncService.asyncMethod();
        return "异步调用中";
    }
}