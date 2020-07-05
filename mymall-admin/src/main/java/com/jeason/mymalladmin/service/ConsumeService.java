package com.jeason.mymalladmin.service;

import com.jeason.inventoryApi.clients.InventoryClient;
import com.jeason.mymalladmin.dto.OrdersDto;
import com.jeason.mymallcommon.util.DateTimeUtil;
import com.jeason.mymallmbg.domain.CommonResult;
import com.jeason.mymallmbg.model.Orderdetails;
import com.jeason.mymallmbg.model.Orders;
import com.jeason.mymallmbg.model.Production;
import com.jeason.orderApi.clients.OrdersClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
        //添加订单
        Orders orders = new Orders();
        orders.setOrdernm(DateTimeUtil.getLocalDateTime().toString());
        orders.setOrderid((Integer) ordersClient.insertOrders(orders).getData());
        for (String order:ordersDto.getOrders()){
            String[] orderArr = order.split(":");
            Integer productionId = Integer.valueOf(orderArr[0]);
            Integer number = Integer.valueOf(orderArr[1]);
            //添加订单详细
            Orderdetails orderdetails = new Orderdetails();
            orderdetails.setOrderid(orders.getOrderid());
            orderdetails.setProductionid(productionId);
            orderdetails.setNumber(number);
            ordersClient.insertOrderDetails(orderdetails);
            //减少库存
            inventoryClient.deleteNProduction(productionId,number);
        }
        return "下单成功";
    }
}
