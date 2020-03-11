package com.lwl.mybatis.origin.entity;

import lombok.Data;

/**
 * author liuweilong
 * date 2020/3/11 11:43 下午
 * desc
 */
@Data
public class Request<T> {
    private String domain;
    private T data;
}
