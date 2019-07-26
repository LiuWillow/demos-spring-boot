package com.lwl.es.service;

import com.lwl.es.util.ESUtils;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.PutMappingRequest;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

/**
 * author liuweilong
 * date 2019/7/26 10:15
 * desc
 */
@Service
@Slf4j
public class IndexOperateServiceImpl implements IndexOperateService{

    @Autowired
    private RestHighLevelClient client;

    /**
     * 创建index
     *
     * @param indexName
     * @param mapping
     */
    @Override
    public void create(String indexName, Map<String, Object> mapping) {
        CreateIndexRequest request = new CreateIndexRequest(indexName);
//        request.settings(Settings.builder()
//                .put("index.number_of_shards", 3)
//                .put("index.number_of_replicas", 2)
//        );

//        Map<String, Object> message = new HashMap<>();
//        message.put("type", "text");
//        Map<String, Object> properties = new HashMap<>();
//        properties.put("message", message);
//        Map<String, Object> mapping = new HashMap<>();
//        mapping.put("properties", properties);
//        request.alias()
        request.mapping(mapping);
        try {
            client.indices().create(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建index
     *
     * @param indexName
     * @param builder
     */
    @Override
    public void create(String indexName, XContentBuilder builder) {
        CreateIndexRequest request = new CreateIndexRequest(indexName);
        request.mapping(builder);
        try {
            client.indices().create(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String indexName) {
        DeleteIndexRequest request = new DeleteIndexRequest(indexName);
        try {
            client.indices().delete(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 也可以和上面两种一样
     *
     * @param clazz
     * @param indexName
     */
    @Override
    public void putMapping(Class clazz, String indexName) {
        PutMappingRequest request = new PutMappingRequest(indexName);
        try {
            XContentBuilder builder = XContentFactory.jsonBuilder();
            builder.startObject();
            ESUtils.analyzeMapping(clazz, builder, indexName);
            builder.endObject();

            request.source(builder);
            client.indices().putMapping(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void create(Class clazz) {
        String indexName = ESUtils.analyzeIndexName(clazz);
        CreateIndexRequest request = new CreateIndexRequest(indexName);
        try {
            XContentBuilder builder = XContentFactory.jsonBuilder();
            ESUtils.analyzeMapping(clazz, builder, indexName);
            request.mapping(builder);
            client.indices().create(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
