package com.lwl.simple;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lwl
 * @date 2019/4/18 9:42
 * @description
 */
@RestController
public class SimpleController {
    @GetMapping("/simple")
    public String hah(){
        return "hah";
    }
}