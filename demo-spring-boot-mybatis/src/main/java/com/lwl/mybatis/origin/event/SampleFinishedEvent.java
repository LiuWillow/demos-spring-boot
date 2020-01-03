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
public class SampleFinishedEvent extends ApplicationEvent {
    /**
     * 消息
     */
    private String message;
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public SampleFinishedEvent(Object source) {
        super(source);
    }
}