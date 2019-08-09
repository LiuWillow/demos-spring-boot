package com.lwl.es.entity.search;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * author liuweilong
 * date 2019/7/31 13:44
 * desc
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface ESIndex {
    /**
     * 索引名称，如果不设置，则默认取类名的驼峰形式
     * @return
     */
    String value();

    /**
     * 分片数量，默认3
     * @return
     */
    int numberOfShards() default 3;

    /**
     * 复制分片数，默认2
     * @return
     */
    int numberOfReplicas() default 2;
}
