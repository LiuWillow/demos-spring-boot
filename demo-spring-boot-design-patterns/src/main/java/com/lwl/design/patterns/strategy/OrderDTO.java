package com.lwl.design.patterns.strategy;

import lombok.Data;

import java.math.BigDecimal;

/**
 * author liuweilong
 * date 2019/10/16 16:21
 * desc
 */
@Data
public class OrderDTO {
    /**
     * 订单号
     */
    private String code;
    /**
     * 加个
     */
    private BigDecimal price;
    /**
     * 订单类型
     * 1： 普通订单
     * 2： 团购订单
     * 3： 促销订单
     */
    private String type;
}
