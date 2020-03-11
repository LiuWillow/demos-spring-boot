package com.lwl.shardingsphere.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lwl.shardingsphere.entity.Order;
import com.lwl.shardingsphere.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.FileVisitOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author liuweilong
 * date 2019/11/12 17:58
 * desc
 */
@Service
@Slf4j
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
        Order selectedOrder = orderMapper.selectOne(new LambdaQueryWrapper<Order>()
                .eq(Order::getCompanyId, order.getCompanyId()).last("limit 1"));
        log.info("insert方法查出来的order:[{}]", selectedOrder);
    }

    @Override
    public Order selectById(Long userId) {
        return orderMapper.selectOne(new LambdaQueryWrapper<Order>()
                .eq(Order::getUserId, userId).last("limit 1"));
    }
}
