package com.mybatis.dao.mapper;

import com.mybatis.entity.Shit;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author lwl
 * @date 2019/4/15 16:44
 * @description
 */
@Repository
public interface ShitMapper {
    @Insert("INSERT INTO shit(id, smell) VALUES (#{shit.id}, #{shit.smell})")
    void insert(@Param("shit") Shit shit);
}