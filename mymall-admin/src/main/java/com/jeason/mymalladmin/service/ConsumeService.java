package com.jeason.mymalladmin.service;

import com.jeason.inventoryApi.clients.InventoryClient;
import com.jeason.mymallmbg.domain.CommonResult;
import com.jeason.mymallmbg.model.Orders;
import com.jeason.mymallmbg.model.Production;
import com.jeason.orderApi.clients.OrdersClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Orders> getOrders(){
        return ordersClient.getOrders();
    }

    public List<Production> getProductions(){
        return inventoryClient.getProductions();
    }

    public String hello1(){
        return inventoryClient.hello();
    }

    public String hello2(){
        return ordersClient.hello();
    }

    public CommonResult getOrderById(int id){
        System.out.println("-------------------"+id);
        return ordersClient.getOrderById(id);
    }
}
