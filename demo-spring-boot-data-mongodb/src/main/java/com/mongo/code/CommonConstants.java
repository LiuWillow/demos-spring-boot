package com.mongo.code;

/**
 * @author lwl
 * @date 2019/4/8 15:18
 * @description 通用常量
 */
public interface CommonConstants {
    /**
     * 启用
     */
    Byte ENABLED = 1;
    /**
     * 禁用
     */
    Byte NOT_ENABLED = 0;

    /**
     * 删除
     */
    Byte DELETE = 1;
    /**
     * 未删除
     */
    Byte NOT_DELETE = 0;

    /**
     * 是否展示 ：展示
     */
    Byte SHOW = 1;
    /**
     * 是否展示 ：不展示
     */
    Byte CLOSE = 0;

    /**
     * 默认分数值
     */
    Byte GRADE_DEFAULT = 5;


    /**
     * 成品
     */
    Integer PLATFORM_MALL = 1;
    /**
     * 大宗
     */
    Integer PLATFORM_MATERIAL = 2;
    /**
     * 没有人
     */
    Long NOBODY = 0L;

    /**
     * 是否默认：是默认
     */
    Byte DEFAULT_VALUE = 1;

    /**
     * 服务调用成功
     */
    String SERVICE_SUCCESS = "0";

    /**
     * 地区
     */
    Byte DELIVERY_STRATEGY_PLACE = 0;

    /**
     * 角色
     */
    Byte DELIVERY_STRATEGY_ROLE = 1;
    /**
     * 已评价
     */
    Byte EVALUATED = 1;
    /**
     * 未评价
     */
    Byte NOT_EVALUATE = 0;

    /**
     * 天，单位毫秒
     */
    int ONE_DAY = 60 * 1000 * 24;
    /**
     * 日期+时间模板
     */
    String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
}