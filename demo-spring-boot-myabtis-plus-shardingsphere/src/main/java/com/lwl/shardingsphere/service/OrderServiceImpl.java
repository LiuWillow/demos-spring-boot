package com.lwl.shardingsphere.service;

import com.lwl.shardingsphere.entity.Order;
import com.lwl.shardingsphere.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * author liuweilong
 * date 2019/11/12 17:58
 * desc
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    @Override
    @Transactional
    public void insert(Order order) {
        orderMapper.insert(order);
        order.setCompanyId(order.getCompanyId()+1);
        order.setUserId(order.getUserId()+1);
        orderMapper.insert(order);
    }
}
