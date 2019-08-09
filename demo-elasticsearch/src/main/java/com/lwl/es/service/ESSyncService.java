package com.lwl.es.service;

/**
 * author liuweilong
 * date 2019/8/5 14:18
 * desc
 */
public interface ESSyncService {
    /**
     * 全量更新
     */
    Byte TYPE_UPDATE = 1;
    /**
     * 全量删除后插入
     */
    Byte TYPE_DELETE_INSERT = 2;

    /**
     * 查询所有已发布的文档数据，整合成es数据结构并同步到es
     * @param syncType
     */
    void syncDocData(Byte syncType);

    /**
     * 查询所有正常状态的空间数据，整合成es数据结构并同步到es
     * @param syncType
     */
    void syncZoneData(Byte syncType);

    /**
     * 查询所有正常状态的评论数据，整合成es数据结构并同步到es
     * @param syncType
     */
    void syncCommentData(Byte syncType);

    /**
     * 查询所有正常状态的附件数据，整合成es数据结构并同步到es
     * @param syncType
     */
    void syncAppendixData(Byte syncType);
}
