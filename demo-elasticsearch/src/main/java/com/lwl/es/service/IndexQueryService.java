package com.lwl.es.service;

import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * author liuweilong
 * date 2019/7/26 10:15
 * desc
 */
public interface IndexQueryService {
    boolean exist(String indexName) throws IOException;
}
