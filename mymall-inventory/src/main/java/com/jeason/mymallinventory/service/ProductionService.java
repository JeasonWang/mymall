package com.jeason.mymallinventory.service;

import com.jeason.mymallmbg.domain.CommonResult;
import com.jeason.mymallmbg.domain.OrdersDto;
import com.jeason.mymallmbg.mapper.ProductionMapper;
import com.jeason.mymallmbg.model.Production;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author: jeason
 * @Description: production
 * @Date: 2020/7/4 23:40
 */
@Service
public class ProductionService {
    @Autowired
    ProductionMapper productionMapper;

    public CommonResult getProductions(){
        return CommonResult.success(productionMapper.selectByExample(null));
    }
    public int insertProduction(Production production){
        int result = productionMapper.insert(production);
        return result;
    }

    public int updateProduction(Production production){
        int result = productionMapper.updateByPrimaryKeySelective(production);
        return result;
    }

    public int deleteProduction(int productionId){
        int result = productionMapper.deleteByPrimaryKey(productionId);
        return result;
    }

    @Transactional
    public void deleteNProduction(OrdersDto ordersDto) {
        for (String orders:ordersDto.getOrders()){
            String[] ordersArr = orders.split(":");
            int productionId = Integer.parseInt(ordersArr[0]);
            int number = Integer.parseInt(ordersArr[1]);
            Production production = productionMapper.selectByPrimaryKey(productionId);
            if(production.getNumber() - number >= 0)
                production.setNumber(production.getNumber() - number);
            else throw new RuntimeException("产品"+productionId+":库存不足");
            productionMapper.updateByPrimaryKeySelective(production);
        }
    }
}
