package com.lwl.es.entity;

import lombok.Data;

import java.util.List;

/**
 * author liuweilong
 * date 2019/7/26 17:03
 * desc
 */
@Data
public class Teacher {
    private String tName;
    private List<String> students;
}
