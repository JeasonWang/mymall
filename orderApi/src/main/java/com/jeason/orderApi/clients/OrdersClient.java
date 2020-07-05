package com.jeason.orderApi.clients;

import com.jeason.mymallmbg.domain.CommonResult;
import com.jeason.mymallmbg.model.Orderdetails;
import com.jeason.mymallmbg.model.Orders;
import com.jeason.orderApi.fallback.OrdersFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: jeason
 * @Description: orders
 * @Date: 2020/7/5 11:02
 */
@FeignClient(name = "mymall-order", path = "/orders", fallback = OrdersFallback.class)
public interface OrdersClient {

    @GetMapping("/orders{ordersId}")
    CommonResult getOrderById(@PathVariable int ordersId);

    @GetMapping("/orders")
    CommonResult getOrders();

    @PostMapping("/orders")
    CommonResult insertOrders(@RequestBody Orders orders);

    @PutMapping("/orders")
    CommonResult updateOrders(@RequestBody Orders orders);

    @DeleteMapping("/orders{ordersId}")
    CommonResult deleteOrders(@PathVariable int ordersId);

    @PostMapping("/insertOrderDetails")
    CommonResult insertOrderDetails(@RequestBody Orderdetails orderdetails);

    @DeleteMapping("/deleteOrderDetails")
    CommonResult deleteOrderDetails(@RequestBody Orderdetails orderdetails);
}