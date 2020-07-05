package com.jeason.orderApi.fallback;

import com.jeason.mymallmbg.domain.CommonResult;
import com.jeason.mymallmbg.model.Orders;
import com.jeason.orderApi.clients.OrdersClient;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: jeason
 * @Description: orders
 * @Date: 2020/7/5 11:07
 */
@Component
public class OrdersFallback implements OrdersClient {

    @Override
    public String hello() {
        return null;
    }

    @Override
    public List<Orders> getOrders() {
        return null;
    }

    @Override
    public CommonResult getOrderById(int ordersId) {
        return null;
    }

    @Override
    public CommonResult insertOrders(Orders orders) {
        return null;
    }

    @Override
    public CommonResult updateOrders(Orders orders) {
        return null;
    }

    @Override
    public CommonResult deleteOrders(int ordersId) {
        return null;
    }
}
