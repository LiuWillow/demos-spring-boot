package com.lwl.es.entity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * author liuweilong
 * date 2019/7/26 13:46
 * desc
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface ESType {
    String value() default "text";
    String format() default "yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis";
}
