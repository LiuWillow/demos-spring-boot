package com.lwl.es.service.impl;

import com.lwl.es.entity.ESIndex;
import com.lwl.es.service.IndexOperateService;
import com.lwl.es.util.ESUtils;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.PutMappingRequest;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.*;

/**
 * author liuweilong
 * date 2019/7/26 10:15
 * desc
 */
@Service
@Slf4j
public class IndexOperateServiceImpl implements IndexOperateService {

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
     */
    @Override
    public void putMapping(Class clazz) {
        String indexName = ESUtils.analyzeIndexName(clazz);
        PutMappingRequest request = new PutMappingRequest(indexName);
        try {
            XContentBuilder builder = XContentFactory.jsonBuilder();
            ESUtils.analyzeMapping(clazz, builder, indexName);
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
            Annotation annotation = clazz.getAnnotation(ESIndex.class);
            //默认3 和 2
            int numberOfShards = 3;
            int numberOfReplicas = 2;
            if (annotation != null){
                ESIndex esIndex = (ESIndex) annotation;
                numberOfShards = esIndex.numberOfShards();
                numberOfReplicas = esIndex.numberOfReplicas();
            }
            request.settings(Settings.builder()
                    .put("index.number_of_shards", numberOfShards)
                    .put("index.number_of_replicas", numberOfReplicas)
            );
            request.mapping(builder);


            client.indices().create(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
