package com.lwl.shardingsphere.controller;

import com.lwl.shardingsphere.entity.Order;
import com.lwl.shardingsphere.service.OrderService;
import com.lwl.shardingsphere.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author liuweilong
 * date 2019/11/12 17:53
 * desc
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping
    public Response<?> insert(@RequestBody Order order){
        orderService.insert(order);
        return Response.success();
    }
}
