package com.flyway.entity;

import lombok.Data;

import java.util.Date;
@Data
public class User {
    private String username;
    private String password;
    private Date date;
}
