package com.jeason.mymalladmin.service;

import com.jeason.inventoryApi.clients.InventoryClient;
import com.jeason.mymallmbg.domain.CommonResult;
import com.jeason.mymallmbg.domain.OrdersDto;
import com.jeason.orderApi.clients.OrdersClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: jeason
 * @Description: consume
 * @Date: 2020/7/5 10:53
 */
@Service
@Slf4j
public class ConsumeService {
    @Autowired
    InventoryClient inventoryClient;

    @Autowired
    OrdersClient ordersClient;

    public CommonResult getOrders(){
        return ordersClient.getOrders();
    }

    public CommonResult getProductions(){
        return inventoryClient.getProductions();
    }

    public CommonResult getOrderById(int id){
        return ordersClient.getOrderById(id);
    }

    public String addOrders(OrdersDto ordersDto) {
        //生成订单
        ordersClient.addOrders(ordersDto);
        //减少库存
        inventoryClient.deleteNProduction(ordersDto);
        return "下单成功";
    }
}
