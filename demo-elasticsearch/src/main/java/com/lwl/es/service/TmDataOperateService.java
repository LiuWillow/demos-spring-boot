package com.lwl.es.service;

import com.lwl.es.entity.TestData;

import java.util.List;

/**
 * author liuweilong
 * date 2019/7/27 10:33
 * desc
 */
public interface TmDataOperateService {
    /**
     * 插入一条数据
     * @param tmData
     */
    void insert(TestData tmData);

    /**
     * 批量插入数据
     * @param tmData
     */
    void insertBatch(List<TestData> tmData);
}
