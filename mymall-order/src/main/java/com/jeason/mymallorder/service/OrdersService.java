package com.jeason.mymallorder.service;

import com.jeason.mymallcommon.util.DateTimeUtil;
import com.jeason.mymallmbg.mapper.OrderdetailsMapper;
import com.jeason.mymallmbg.mapper.OrdersMapper;
import com.jeason.mymallmbg.model.Orderdetails;
import com.jeason.mymallmbg.model.Orders;
import com.jeason.mymallorder.domain.OrdersDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public int insertOrders(Orders orders){
        ordersMapper.insert(orders);
        return orders.getOrderid();
    }

    @Transactional
    public int updateOrders(Orders orders){
        int result = ordersMapper.updateByPrimaryKeySelective(orders);
        return result;
    }

    @Transactional
    public int deleteOrders(int ordersId){
        int result = ordersMapper.deleteByPrimaryKey(ordersId);
        return result;
    }

    @Transactional
    public int insertOrderDetails(Orderdetails orderdetails){
        return orderdetailsMapper.insert(orderdetails);
    }

    @Transactional
    public int deleteOrderDetails(Orderdetails orderdetails){
        return orderdetailsMapper.deleteByPrimaryKey(orderdetails.getOrderid(),orderdetails.getProductionid());
    }

    @Transactional
    public String addOrders(OrdersDto ordersDto) {
        //添加订单
        Orders orders = new Orders();
        orders.setOrdernm(DateTimeUtil.getLocalDateTime().toString());
        orders.setOrderid(insertOrders(orders));
        for (String order:ordersDto.getOrders()){
            String[] orderArr = order.split(":");
            Integer productionId = Integer.valueOf(orderArr[0]);
            Integer number = Integer.valueOf(orderArr[1]);
            //添加订单详细
            Orderdetails orderdetails = new Orderdetails();
            orderdetails.setOrderid(orders.getOrderid());
            orderdetails.setProductionid(productionId);
            orderdetails.setNumber(number);
            insertOrderDetails(orderdetails);
        }
        return "下单成功";
    }
}
