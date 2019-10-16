package com.lwl.design.patterns.strategy.handler;

import com.lwl.design.patterns.strategy.OrderDTO;

/**
 * author liuweilong
 * date 2019/10/16 16:23
 * desc
 */
public abstract class AbstractOrderHandler {
    abstract public String handle(OrderDTO orderDTO);
}
