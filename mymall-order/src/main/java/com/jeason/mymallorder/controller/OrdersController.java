package com.jeason.mymallorder.controller;

import com.jeason.mymallmbg.domain.CommonResult;
import com.jeason.mymallmbg.model.Orderdetails;
import com.jeason.mymallmbg.model.Orders;
import com.jeason.mymallorder.service.OrdersService;
import org.apache.ibatis.annotations.Param;
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

    @GetMapping("/orders{ordersId}")
    public CommonResult getOrderById(@PathVariable int ordersId){
        return CommonResult.success(ordersService.getOrderById(ordersId));
    }

    @GetMapping("/orders")
    public CommonResult getOrders(){
        return CommonResult.success(ordersService.getOrders());
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

    @PostMapping("/insertOrderDetails")
    public CommonResult insertOrderDetails(@RequestBody Orderdetails orderdetails){
        return CommonResult.success(ordersService.insertOrderDetails(orderdetails));
    }

    @DeleteMapping("/deleteOrderDetails")
    public CommonResult deleteOrderDetails(@RequestBody Orderdetails orderdetails){
        return CommonResult.success(ordersService.deleteOrderDetails(orderdetails));
    }
}
