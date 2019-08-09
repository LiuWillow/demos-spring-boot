package com.lwl.es.service;

import com.lwl.es.em.ESDataType;
import com.lwl.es.entity.search.TmData;
import com.lwl.es.to.TmDataDeleteTO;
import com.lwl.es.to.TmDataDirectUpdateTO;
import com.lwl.es.to.TmDataInDirectUpdateTO;
import com.lwl.es.to.TmDataUpdateTO;

import java.util.List;

/**
 * author liuweilong
 * date 2019/7/27 10:33
 * desc
 */
public interface TmDataOperateService {
    String SCRIPT_SOURCE = "ctx._source.";

    /**
     * 根据实体类型创建索引
     * @param clazz
     */
    void createIndex(Class clazz);

    /**
     * 插入一条数据
     * @param tmData
     */
    boolean insert(TmData tmData);

    /**
     * 批量插入数据
     * @param tmData
     * @return 是否成功
     */
    boolean insertBatch(List<TmData> tmData);

    /**
     * 根据entityId，公司id，数据类型删除对应的数据
     * @param deleteTO
     */
    boolean delete(TmDataDeleteTO deleteTO);

    /**
     * 更新或插入
     * @param tmData
     */
    boolean upsert(TmData tmData);

    /**
     * 根据es数据类型批量删除数据
     * @param dataType
     */
    boolean deleteBatchByType(ESDataType dataType, Long companyId);

    /**
     * 根据条件更新指定字段
     * @param updateTO
     * @return
     */
    boolean updateByQuery(TmDataUpdateTO updateTO);

    /**
     * 更新直接相关的数据
     * @param updateTO
     * @return
     */
    boolean updateTmDirectByQuery(TmDataDirectUpdateTO updateTO);

    /**
     * 更新间接相关的数据
     * @param updateTO
     * @return
     */
    boolean updateTmInDirectByQuery(TmDataInDirectUpdateTO updateTO);
}
