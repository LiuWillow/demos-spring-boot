package com.lwl.mybatis.origin.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.context.ApplicationEvent;

/**
 * author liuweilong
 * date 2020/1/3 2:23 下午
 * desc
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SimpleEvent extends ApplicationEvent {
    /**
     * 消息
     */
    private String message;

    public SimpleEvent(Object source){
        super(source);
    }
}