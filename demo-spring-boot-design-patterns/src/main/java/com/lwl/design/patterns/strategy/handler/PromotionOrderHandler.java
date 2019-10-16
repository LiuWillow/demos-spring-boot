package com.lwl.design.patterns.strategy.handler;

import com.lwl.design.patterns.strategy.OrderDTO;
import com.lwl.design.patterns.strategy.OrderType;
import org.springframework.stereotype.Component;

/**
 * author liuweilong
 * date 2019/10/16 16:24
 * desc
 */
@Component(OrderType.PROMOTION)
public class PromotionOrderHandler extends AbstractOrderHandler {
    @Override
    public String handle(OrderDTO orderDTO) {
        return "处理促销订单";
    }
}
