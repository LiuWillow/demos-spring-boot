package com.lwl.mybatis.multi.controller;

import com.lwl.mybatis.multi.entity.User;
import com.lwl.mybatis.multi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author liuweilong
 * @description
 * @date 2019/7/2 17:02
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("{userId}")
    public User getUserById(@PathVariable("userId") Long userId){
        return userService.getUser(userId);
    }

    @PostMapping
    public String add(@RequestBody User user){
        userService.insertUser(user);
        return "success";
    }
}
