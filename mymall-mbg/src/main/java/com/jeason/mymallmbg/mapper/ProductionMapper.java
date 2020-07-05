package com.jeason.mymallmbg.mapper;

import com.jeason.mymallmbg.model.Production;
import com.jeason.mymallmbg.model.ProductionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductionMapper {
    long countByExample(ProductionExample example);

    int deleteByExample(ProductionExample example);

    int deleteByPrimaryKey(Integer productionid);

    int insert(Production record);

    int insertSelective(Production record);

    List<Production> selectByExample(ProductionExample example);

    Production selectByPrimaryKey(Integer productionid);

    int updateByExampleSelective(@Param("record") Production record, @Param("example") ProductionExample example);

    int updateByExample(@Param("record") Production record, @Param("example") ProductionExample example);

    int updateByPrimaryKeySelective(Production record);

    int updateByPrimaryKey(Production record);
}