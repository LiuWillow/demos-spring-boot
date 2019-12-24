package com.lwl.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author liuweilong
 * date 2019/12/19 2:27 下午
 * desc
 */
@Controller
@RequestMapping("/")
public class PageController {
    @RequestMapping("/liuweilong/app/page")
    public String liuweilongAppPage(){
        return "eleIndex";
    }
}