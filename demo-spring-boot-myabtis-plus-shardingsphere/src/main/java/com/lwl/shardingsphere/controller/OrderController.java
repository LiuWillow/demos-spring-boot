package com.lwl.shardingsphere.controller;

import com.lwl.shardingsphere.entity.Order;
import com.lwl.shardingsphere.service.OrderService;
import com.lwl.shardingsphere.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * author liuweilong
 * date 2019/11/12 17:53
 * desc
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("shit")
    public Response<?> insert(@RequestBody Order order){
        orderService.insert(order);
        return Response.success();
    }

    @GetMapping("{id}")
    public Response<Order> select(@PathVariable("id") Long id){
        Order order = orderService.selectById(id);
        return Response.success(order);
    }

}
