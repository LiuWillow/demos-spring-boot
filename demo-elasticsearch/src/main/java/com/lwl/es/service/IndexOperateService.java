package com.lwl.es.service;

import org.elasticsearch.common.xcontent.XContentBuilder;

import java.util.Map;

/**
 * author liuweilong
 * date 2019/7/26 18:08
 * desc
 */
public interface IndexOperateService {
    void create(String indexName, Map<String, Object> mapping);
    void create(String indexName, XContentBuilder builder);
    void delete(String indexName);
    void putMapping(Class clazz);
    void create(Class clazz);
}
