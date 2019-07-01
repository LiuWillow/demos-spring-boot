package com.lwl.mongo.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author wangyuan
 */
@Data
public class DeliveryStrategyValue {
    @NotNull(message = "{delivery_strategy_value_not_null}")
    private Integer deliveryStrategyValueId;

    @NotNull(message = "{delivery_strategy_value_not_null}")
    private String deliveryStrategyValueName;
}
