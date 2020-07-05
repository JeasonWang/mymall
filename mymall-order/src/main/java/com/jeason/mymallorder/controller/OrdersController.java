package com.jeason.mymallorder.controller;

import com.jeason.mymallmbg.domain.CommonResult;
import com.jeason.mymallmbg.model.Orders;
import com.jeason.mymallorder.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: jeason
 * @Description: hello
 * @Date: 2020/7/4 23:20
 */
@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    OrdersService ordersService;
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/orders{ordersId}")
    public CommonResult getOrderById(@PathVariable int ordersId){
        return CommonResult.success(ordersService.getOrderById(ordersId));
    }

    @GetMapping("/orders")
    public List<Orders> getOrders(){
        return ordersService.getOrders();
    }

    @PostMapping("/orders")
    public CommonResult insertOrders(@RequestBody Orders orders){
        return CommonResult.success(ordersService.insertOrders(orders));
    }

    @PutMapping("/orders")
    public CommonResult updateOrders(@RequestBody Orders orders){
        return CommonResult.success(ordersService.updateOrders(orders));
    }

    @DeleteMapping("/orders{ordersId}")
    public CommonResult deleteOrders(@PathVariable int ordersId){
        return CommonResult.success(ordersService.deleteOrders(ordersId));
    }
}
