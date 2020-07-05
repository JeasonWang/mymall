package com.jeason.mymallorder.service;

import com.jeason.mymallmbg.mapper.OrdersMapper;
import com.jeason.mymallmbg.model.Orders;
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

    public List<Orders> getOrders(){
        return ordersMapper.selectByExample(null);
    }

    public Orders getOrderById(int ordersId){
        return ordersMapper.selectByPrimaryKey(ordersId);
    }

    public int insertOrders(Orders orders){
        int result = ordersMapper.insert(orders);
        return result;
    }

    public int updateOrders(Orders orders){
        int result = ordersMapper.updateByPrimaryKeySelective(orders);
        return result;
    }

    public int deleteOrders(int ordersId){
        int result = ordersMapper.deleteByPrimaryKey(ordersId);
        return result;
    }
}
