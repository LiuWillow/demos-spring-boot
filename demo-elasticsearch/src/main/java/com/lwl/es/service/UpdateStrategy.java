package com.lwl.es.service;

import com.lwl.es.to.TmDataInDirectUpdateTO;

import java.util.Map;

/**
 * author liuweilong
 * date 2019/8/8 17:00
 * desc
 */
public interface UpdateStrategy {
    /**
     * 组装更新请求数据
     * @param updateTO
     * @param queryMap
     * @param fieldMap
     */
    void generateUpdateMap(TmDataInDirectUpdateTO updateTO, Map<String, Object> queryMap, Map<String, Object> fieldMap);
}
