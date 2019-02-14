package com.mongo.entity;

import lombok.Data;

import java.util.List;

/**
 * @author lwl
 * @date 2018/10/19 9:19
 * @description
 */
@Data
public class PageModule<T> {
    private int totalPage;
    private int currentPage;
    private int currentCount;
    private List<T> data;
}