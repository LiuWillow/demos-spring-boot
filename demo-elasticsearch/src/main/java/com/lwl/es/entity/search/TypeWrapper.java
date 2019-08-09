package com.lwl.es.entity.search;

import lombok.Data;

/**
 * author liuweilong
 * date 2019/7/31 16:54
 * desc
 */
@Data
public class TypeWrapper {
    /**
     * 字段对应的es类型
     */
    private String type;
    /**
     * 字段的java类型
     */
    private Class clazz;
}
