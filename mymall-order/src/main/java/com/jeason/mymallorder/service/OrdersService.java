package com.jeason.mymallorder.service;

import com.jeason.mymallmbg.mapper.OrderdetailsMapper;
import com.jeason.mymallmbg.mapper.OrdersMapper;
import com.jeason.mymallmbg.model.Orderdetails;
import com.jeason.mymallmbg.model.Orders;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: jeason
 * @Description: Order
 * @Date: 2020/7/4 23:40
 */
@Service
public class OrdersService {
    @Autowired
    OrdersMapper ordersMapper;
    @Autowired
    OrderdetailsMapper orderdetailsMapper;

    public List<Orders> getOrders(){
        return ordersMapper.selectByExample(null);
    }

    public Orders getOrderById(int ordersId){
        return ordersMapper.selectByPrimaryKey(ordersId);
    }

    public int insertOrders(Orders orders){
        ordersMapper.insert(orders);
        return orders.getOrderid();
    }

    public int updateOrders(Orders orders){
        int result = ordersMapper.updateByPrimaryKeySelective(orders);
        return result;
    }

    public int deleteOrders(int ordersId){
        int result = ordersMapper.deleteByPrimaryKey(ordersId);
        return result;
    }

    public int insertOrderDetails(Orderdetails orderdetails){
        return orderdetailsMapper.insert(orderdetails);
    }

    public int deleteOrderDetails(Orderdetails orderdetails){
        return orderdetailsMapper.deleteByPrimaryKey(orderdetails.getOrderid(),orderdetails.getProductionid());
    }
}
