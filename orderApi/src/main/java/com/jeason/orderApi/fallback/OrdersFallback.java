package com.jeason.orderApi.fallback;

import com.jeason.mymallmbg.domain.CommonResult;
import com.jeason.mymallmbg.model.Orderdetails;
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
    public CommonResult getOrderById(int ordersId) {
        return null;
    }

    @Override
    public CommonResult getOrders() {
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

    @Override
    public CommonResult insertOrderDetails(Orderdetails orderdetails) {
        return null;
    }

    @Override
    public CommonResult deleteOrderDetails(Orderdetails orderdetails) {
        return null;
    }
}
