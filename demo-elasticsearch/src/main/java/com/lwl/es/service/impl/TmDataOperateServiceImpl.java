package com.lwl.es.service.impl;

import com.alibaba.fastjson.JSON;
import com.lwl.es.em.ESDataType;
import com.lwl.es.entity.search.ESIndex;
import com.lwl.es.entity.search.ESData;
import com.lwl.es.service.TmDataOperateService;
import com.lwl.es.service.UpdateStrategy;
import com.lwl.es.to.TmDataDeleteTO;
import com.lwl.es.to.TmDataDirectUpdateTO;
import com.lwl.es.to.TmDataInDirectUpdateTO;
import com.lwl.es.to.TmDataUpdateTO;
import com.lwl.es.util.ESUtils;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryRequest;
import org.elasticsearch.index.reindex.UpdateByQueryRequest;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.script.Script;
import org.elasticsearch.script.ScriptType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.*;
import java.util.stream.Collectors;

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
    private Map<String, UpdateStrategy> updateStrategies;

    @Override
    public boolean insertBatch(List<ESData> testDataList) {
        if (CollectionUtils.isEmpty(testDataList)) {
            log.warn("es要插入的数据列表为空");
            return true;
        }
        BulkRequest request = new BulkRequest();
        log.warn("es要插入的数据列表长度为{}", testDataList.size());

        //插入的时候指定路由为companyId
        testDataList.forEach(tmData -> request.add(new IndexRequest(ESData.INDEX_NAME)
                .source(JSON.toJSONString(tmData), XContentType.JSON)
                .routing(tmData.getCompanyId().toString())));
        try {
            BulkResponse response = client.bulk(request, RequestOptions.DEFAULT);
            boolean hasFailure = response.hasFailures();
            if (hasFailure){
                List<BulkItemResponse> failList = Arrays.stream(response.getItems())
                        .filter(BulkItemResponse::isFailed).collect(Collectors.toList());
                log.error("批量插入没有完全成功，有{}条数据插入失败", failList.size());
                failList.forEach(errorResponse -> log.error("批量插入异常记录信息：{}", errorResponse.getFailureMessage()));
            } else {
                log.info("批量插入成功");
            }
            return !hasFailure;
        } catch (IOException e) {
            log.error("批量插入es数据io异常", e);
        }
        return false;
    }

    @Override
    public boolean delete(TmDataDeleteTO deleteTO) {
        if (Objects.isNull(deleteTO)){
            log.warn("deleteTO为空");
            return true;
        }
        log.info("es要删除的TO为：{}", JSON.toJSONString(deleteTO));
        DeleteByQueryRequest request = new DeleteByQueryRequest(ESData.INDEX_NAME);
        request.setRouting(deleteTO.getCompanyId().toString());
        request.setQuery(QueryBuilders.boolQuery().must(QueryBuilders.termQuery(ESData.ENTITY_ID, deleteTO.getEntityId()))
                .must(QueryBuilders.termQuery(ESData.COMPANY_ID, deleteTO.getCompanyId()))
                .must(QueryBuilders.termQuery(ESData.DATA_TYPE, deleteTO.getDataType())));
        try {
            BulkByScrollResponse response = client.deleteByQuery(request, RequestOptions.DEFAULT);
            List<BulkItemResponse.Failure> bulkFailures = response.getBulkFailures();

            boolean success = bulkFailures.isEmpty();
            if (!success) {
                log.error("es删除异常，有{}处错误", bulkFailures.size());
                bulkFailures.forEach(bulkFailure -> log.error("es删除错误信息：{}", bulkFailure.getCause()));
                return false;
            }
            return true;
        } catch (IOException e) {
            log.error("删除es数据IO异常", e);
        }
        return false;
    }

    @Override
    public boolean upsert(ESData ESData) {
        log.info("进入upsert方法，请求参数为：{}", JSON.toJSONString(ESData));
        TmDataDeleteTO deleteTO = new TmDataDeleteTO();
        deleteTO.setCompanyId(ESData.getCompanyId());
        deleteTO.setEntityId(ESData.getEntityId());
        boolean deleted = delete(deleteTO);
        if (!deleted) {
            return false;
        }
        return insert(ESData);
    }

    @Override
    public boolean deleteBatchByType(ESDataType dataType, Long companyId) {
        log.info("进入根据类型批量删除方法，要删除的类型为：{}，要删除的公司id为：{}", dataType.getTypeDesc(), companyId);
        DeleteByQueryRequest request = new DeleteByQueryRequest(ESData.INDEX_NAME);
        request.setQuery(QueryBuilders.boolQuery().must(QueryBuilders.termQuery(ESData.DATA_TYPE, dataType.getTypeId()))
                .must(QueryBuilders.termQuery(ESData.COMPANY_ID, companyId)));
        try {
            BulkByScrollResponse response = client.deleteByQuery(request, RequestOptions.DEFAULT);
            List<BulkItemResponse.Failure> bulkFailures = response.getBulkFailures();

            boolean success = bulkFailures.isEmpty();
            if (!success){
                log.error("根据类型删除数据不完全成功，有{}条异常记录", bulkFailures.size());
                bulkFailures.forEach(bulkFailure -> log.error("根据类型删除异常信息：", bulkFailure.getCause()));
                return false;
            }
            return true;
        } catch (IOException e) {
            log.error("根据类型批量删除异常", e);
        }
        return false;
    }

    @Override
    public boolean updateByQuery(TmDataUpdateTO updateTO) {
        log.info("进入updateByQuery方法，参数为：{}", JSON.toJSONString(updateTO));
        UpdateByQueryRequest request = new UpdateByQueryRequest(ESData.INDEX_NAME);
        Map<String, Object> modifyFields = updateTO.getModifyFields();
        Date current = new Date();
        modifyFields.put(ESData.DATA_UPDATE_TIME, current);

        request.setRouting(updateTO.getCompanyId().toString());
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery().must(QueryBuilders.termQuery(ESData.COMPANY_ID,
                updateTO.getCompanyId()));

        Map<String, Object> queryFields = updateTO.getQueryFields();
        if (Objects.nonNull(queryFields)) {
            queryFields.forEach((key, value) -> boolQueryBuilder.must(QueryBuilders.termQuery(key, value)));
        }
        request.setQuery(boolQueryBuilder);

        StringBuilder scriptBuilder = new StringBuilder();
        Map<String, Object> paramsMap = new HashMap<>();
        injectScriptAndParamsMap(modifyFields, scriptBuilder, paramsMap);

        Script script = new Script(ScriptType.INLINE, "painless", scriptBuilder.toString(),
                paramsMap);
        request.setScript(script);
        try {
            BulkByScrollResponse response = client.updateByQuery(request, RequestOptions.DEFAULT);
            List<BulkItemResponse.Failure> bulkFailures = response.getBulkFailures();
            boolean success = bulkFailures.isEmpty();
            if (!success){
                log.error("根据查询参数更新数据不完全成功，有{}条异常记录", bulkFailures.size());
                bulkFailures.forEach(bulkFailure -> log.error("根据查询参数更新数据异常信息：", bulkFailure.getCause()));
                return false;
            }
            return true;
        } catch (IOException e) {
            log.error("根据查询更新es数据IO异常", e);
        }
        return false;

    }


    @Override
    public boolean updateTmDirectByQuery(TmDataDirectUpdateTO updateTO) {
        Map<String, Object> simpleQueryMap = new HashMap<>();
        simpleQueryMap.put(ESData.COMPANY_ID, updateTO.getCompanyId());
        Byte dataType = updateTO.getDataType();
        simpleQueryMap.put(ESData.DATA_TYPE, dataType);
        simpleQueryMap.put(ESData.ENTITY_ID, updateTO.getEntityId());

        Map<String, Object> simpleFieldMap = new HashMap<>();
        if (!StringUtils.isEmpty(updateTO.getIconUrl())) {
            simpleFieldMap.put(ESData.ICON_URL, updateTO.getIconUrl());
        }
        if (!StringUtils.isEmpty(updateTO.getContent())) {
            simpleFieldMap.put(ESData.CONTENT, updateTO.getContent());
        }
        if (!CollectionUtils.isEmpty(updateTO.getContributors())) {
            simpleFieldMap.put(ESData.CONTRIBUTORS, updateTO.getContributors());
        }
        if (Objects.nonNull(updateTO.getFlagExpert())) {
            simpleFieldMap.put(ESData.FLAG_EXPERT, updateTO.getFlagExpert());
        }
        simpleFieldMap.put(ESData.SOURCE_UPDATE_TIME, updateTO.getSourceUpdateTime());
        if (Objects.nonNull(updateTO.getWhiteDepartmentIdList())) {
            simpleFieldMap.put(ESData.WHITE_DEPARTMENT_ID_LIST, updateTO.getWhiteDepartmentIdList());
        }
        if (Objects.nonNull(updateTO.getWhitePositionIdList())) {
            simpleFieldMap.put(ESData.WHITE_POSITION_ID_LIST, updateTO.getWhitePositionIdList());
        }
        if (Objects.nonNull(updateTO.getWhiteUserGroupIdList())) {
            simpleFieldMap.put(ESData.WHITE_USER_GROUP_ID_LIST, updateTO.getWhiteUserGroupIdList());
        }
        if (Objects.nonNull(updateTO.getWhiteUserIdList())) {
            simpleFieldMap.put(ESData.WHITE_USER_ID_LIST, updateTO.getWhiteUserIdList());
        }
        if (Objects.nonNull(updateTO.getPraiseNum())) {
            simpleFieldMap.put(ESData.PRAISE_NUM, updateTO.getPraiseNum());
        }
        if (Objects.nonNull(updateTO.getReadNum())) {
            simpleFieldMap.put(ESData.READ_NUM, updateTO.getReadNum());
        }
        if (Objects.nonNull(updateTO.getFavoriteNum())) {
            simpleFieldMap.put(ESData.FAVORITE_NUM, updateTO.getFavoriteNum());
        }
        if (Objects.nonNull(updateTO.getRefTimes())) {
            simpleFieldMap.put(ESData.REF_TIMES, updateTO.getRefTimes());
        }
        if (Objects.nonNull(updateTO.getDownloadTimes())) {
            simpleFieldMap.put(ESData.DOWNLOAD_TIMES, updateTO.getDownloadTimes());
        }
        if (Objects.nonNull(updateTO.getChildCommentQuantity())) {
            simpleFieldMap.put(ESData.CHILD_COMMENT_QUANTITY, updateTO.getChildCommentQuantity());
        }

        TmDataUpdateTO tmDataUpdateTO = new TmDataUpdateTO();
        tmDataUpdateTO.setCompanyId(updateTO.getCompanyId());
        tmDataUpdateTO.setQueryFields(simpleQueryMap);
        tmDataUpdateTO.setModifyFields(simpleFieldMap);
        return updateByQuery(tmDataUpdateTO);
    }

    @Override
    public boolean updateTmInDirectByQuery(TmDataInDirectUpdateTO updateTO) {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put(ESData.COMPANY_ID, updateTO.getCompanyId());
        Map<String, Object> fieldMap = new HashMap<>();
        UpdateStrategy updateStrategy = updateStrategies.get(updateTO.getUpdateType().getStrategy());
        updateStrategy.generateUpdateMap(updateTO, queryMap, fieldMap);

        TmDataUpdateTO tmDataUpdateTO = new TmDataUpdateTO();
        tmDataUpdateTO.setCompanyId(updateTO.getCompanyId());
        tmDataUpdateTO.setQueryFields(queryMap);
        tmDataUpdateTO.setModifyFields(fieldMap);
        return updateByQuery(tmDataUpdateTO);
    }

    @Override
    public void createIndex(Class clazz) {
        String indexName = ESUtils.analyzeIndexName(clazz);
        CreateIndexRequest request = new CreateIndexRequest(indexName);

        try {
            XContentBuilder builder = XContentFactory.jsonBuilder();
            ESUtils.analyzeMapping(clazz, builder, indexName);
            Annotation annotation = clazz.getAnnotation(ESIndex.class);
            //默认3 和 2
            int numberOfShards = 3;
            int numberOfReplicas = 2;
            if (annotation != null) {
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
            log.error("创建索引异常", e);
        }
    }

    @Override
    public boolean insert(ESData ESData) {
        log.info("进入插入es数据方法，参数为：{}", JSON.toJSONString(ESData));
        IndexRequest request = new IndexRequest(ESData.INDEX_NAME);
        request.source(JSON.toJSONString(ESData), XContentType.JSON);
        //指定路由为公司id
        request.routing(ESData.getCompanyId().toString());
        try {
            IndexResponse response = client.index(request, RequestOptions.DEFAULT);
            return RestStatus.CREATED.equals(response.status());
        } catch (IOException e) {
            log.error("插入es数据io异常", e);
        }
        return false;
    }



    private void injectScriptAndParamsMap(Map<String, Object> modifyFields, StringBuilder scriptBuilder, Map<String, Object> paramsMap) {
        modifyFields.forEach((key, value) -> {
            scriptBuilder.append(SCRIPT_SOURCE).append(key).append("=");
            if (value instanceof String) {
                String paramsKey = getParamKey(key);
                paramsMap.put(paramsKey, value);
                scriptBuilder.append("params.").append(paramsKey).append(";");
            } else if (value instanceof Date) {
                long timeMills = ((Date) value).getTime();
                scriptBuilder.append(timeMills).append(";");
            } else if (value instanceof Number) {
                scriptBuilder.append(value).append(";");
            } else if (value instanceof List) {
                List<?> list = (List) value;
                if (!CollectionUtils.isEmpty(list)) {
                    Object innerObject = list.get(0);
                    String jsonString = JSON.toJSONString(value);
                    if (innerObject instanceof Number) {
                        scriptBuilder.append(jsonString).append(";");
                    } else {
                        String paramsKey = getParamKey(key);
                        paramsMap.put(paramsKey, value);
                        scriptBuilder.append("params.").append(paramsKey).append(";");
                    }
                }
            }
        });
    }

    private String getParamKey(String key) {
        int index = key.lastIndexOf(".");
        String paramsKey = key;
        if (index != -1) {
            paramsKey = key.substring(index + 1, key.length());
        }
        return paramsKey;
    }
}
