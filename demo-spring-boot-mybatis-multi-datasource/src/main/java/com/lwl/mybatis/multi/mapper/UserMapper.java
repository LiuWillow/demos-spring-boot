package com.lwl.mybatis.multi.mapper;

import com.lwl.mybatis.multi.aop.Slave;
import com.lwl.mybatis.multi.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author liuweilong
 * @description
 * @date 2019/7/2 16:56
 */
public interface UserMapper {
    @Select("select * from `user` where user_id = #{userId}")
    User selectUserById(@Param("userId") Long userId);

    @Insert("insert into `user` (user_id, `name`, age) values (#{user.userId}, #{user.name}, #{user.age})")
    void insert(@Param("user") User user);
}
