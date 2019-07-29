package com.lwl.es.service.impl;

import com.lwl.es.service.IndexQueryService;
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
@Service
public class IndexQueryServiceImpl implements IndexQueryService {
    @Autowired
    private RestHighLevelClient client;

    @Override
    public boolean exist(String indexName) throws IOException {
        GetIndexRequest request = new GetIndexRequest(indexName);
        return client.indices().exists(request, RequestOptions.DEFAULT);
    }
}
