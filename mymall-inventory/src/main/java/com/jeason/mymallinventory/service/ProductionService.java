package com.jeason.mymallinventory.service;

import com.jeason.mymallmbg.mapper.ProductionMapper;
import com.jeason.mymallmbg.model.Production;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: jeason
 * @Description: production
 * @Date: 2020/7/4 23:40
 */
@Service
public class ProductionService {
    @Autowired
    ProductionMapper productionMapper;

    public List<Production> getProductions(){
        return productionMapper.selectByExample(null);
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
}
