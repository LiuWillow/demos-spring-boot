package com.lwl.mybatis.multi.service;

import com.lwl.mybatis.multi.aop.Slave;
import com.lwl.mybatis.multi.entity.User;
import com.lwl.mybatis.multi.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuweilong
 * @description
 * @date 2019/7/2 16:59
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Slave
    public User getUser(Long userId){
        return userMapper.selectUserById(userId);
    }

    public void insertUser(User user) {
        userMapper.insert(user);
    }
}
