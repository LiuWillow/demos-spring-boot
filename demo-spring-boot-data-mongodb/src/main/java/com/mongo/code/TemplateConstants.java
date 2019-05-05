package com.mongo.code;

/**
 * @author lwl
 * @date 2019/4/8 15:17
 * @description 模板相关常量
 */
public interface TemplateConstants {
    /**
     * 同一时间内最大有效模板数
     */
    int MAX_AVAILABLE_TPL = 1;
    /**
     * 投放策略类型——地区
     */
    Byte DELIVERY_STRATEGY_TYPE_AREA = 0;
    /**
     * 投放策略类型——角色
     */
    Byte DELIVERY_STRATEGY_TYPE_ROLE = 1;
    /**
     * 开放式问题
     */
    Byte QUESTION_TYPE_OPEN = 0;
    /**
     * 封闭式问题
     */
    Byte QUESTION_TYPE_CLOSE = 1;
    /**
     * 默认标识
     */
    Byte DEFAULT_FLAG = 1;

    /**
     * 模板策略只有一个
     */
    int SINGLE_STRATEGY_SIZE = 1;
}