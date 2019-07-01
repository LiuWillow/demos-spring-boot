package com.lwl.mongo.entity;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author: wangyuan
 * @Date: 2019/4/11 14:21
 * @description
 */
@Data
public class DeliveryStrategy {
    @NotNull(message = "{delivery_strategy_type_not_null}")
    @Min(value = 0, message = "{delivery_strategy_type_error}")
    @Max(value = 1, message = "{delivery_strategy_type_error}")
    private Byte deliveryStrategyType;

    @NotNull(message = "{delivery_strategy_value_not_null}")
    private List<DeliveryStrategyValue> deliveryStrategyValues;
}
