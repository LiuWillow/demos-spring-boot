package com.flyway.dao.mapper;

import com.flyway.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User getUserByUsername(String username);
}