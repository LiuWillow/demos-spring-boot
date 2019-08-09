package com.lwl.es.entity.search;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * author liuweilong
 * date 2019/7/31 13:46
 * desc
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface ESField {
    String type() default "";
    String format() default "";
    String termVector() default "";
}
