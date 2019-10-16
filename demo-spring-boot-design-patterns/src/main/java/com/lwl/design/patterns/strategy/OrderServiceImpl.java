package com.lwl.design.patterns.strategy;

import com.lwl.design.patterns.strategy.handler.AbstractOrderHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * author liuweilong
 * date 2019/10/16 16:31
 * desc
 */
@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private Map<String, AbstractOrderHandler> handlerMap;
    @Override
    public String handle(OrderDTO orderDTO) {
        return handlerMap.get(orderDTO.getType()).handle(orderDTO);
    }
}
