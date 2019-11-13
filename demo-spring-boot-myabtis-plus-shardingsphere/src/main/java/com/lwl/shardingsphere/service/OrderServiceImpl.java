package com.lwl.shardingsphere.service;

import com.lwl.shardingsphere.entity.Order;
import com.lwl.shardingsphere.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author liuweilong
 * date 2019/11/12 17:58
 * desc
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public void insert(Order order) {
        orderMapper.insert(order);
    }
}
