package com.lwl.es.service.impl;

import com.alibaba.fastjson.JSON;
import com.lwl.es.entity.TestData;
import com.lwl.es.service.IndexOperateService;
import com.lwl.es.service.IndexQueryService;
import com.lwl.es.service.TmDataOperateService;
import com.lwl.es.util.ESUtils;
import com.lwl.es.util.SnowFlakeIdWorker;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * author liuweilong
 * date 2019/7/27 10:36
 * desc
 */
@Service
@Slf4j
public class TmDataOperateServiceImpl implements TmDataOperateService {
    @Autowired
    private RestHighLevelClient client;
    @Autowired
    private IndexQueryService indexQueryService;
    @Autowired
    private IndexOperateService indexOperateService;

    @Override
    public void insert(TestData tmData) {
        IndexRequest request = new IndexRequest(ESUtils.analyzeIndexName(TestData.class));
        request.id(SnowFlakeIdWorker.getInstance().nextId() + "");
        request.source(JSON.toJSONString(tmData), XContentType.JSON);
        try {
            client.index(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertBatch(List<TestData> tmDataList) {
        if (CollectionUtils.isEmpty(tmDataList)) {
            return;
        }
        try {
            boolean exist = indexQueryService.exist("tm_data");
            if (!exist){
                log.info("索引不存在，正在创建索引");
                indexOperateService.create(TestData.class);
            }
            log.info("正在组装请求...");
            BulkRequest request = new BulkRequest();

            AtomicInteger count = new AtomicInteger(0);
            tmDataList.forEach(tmData -> {
                request.add(new IndexRequest("tm_data")
                        .id(SnowFlakeIdWorker.getInstance().nextId() + "")
                        .source(JSON.toJSONString(tmData), XContentType.JSON)
                        .routing(tmData.getCompanyId().toString()));
                count.getAndIncrement();
                if (count.get() % 1000 == 0){
                    log.info("已组装{}条记录", count.get());
                }
            });
            log.info("正在插入...");
            client.bulk(request, RequestOptions.DEFAULT);
            log.info("全部插入成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
