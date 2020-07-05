package com.jeason.mymallmbg.mapper;

import com.jeason.mymallmbg.model.Orderdetails;
import com.jeason.mymallmbg.model.OrderdetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderdetailsMapper {
    long countByExample(OrderdetailsExample example);

    int deleteByExample(OrderdetailsExample example);

    int deleteByPrimaryKey(@Param("orderid") Integer orderid, @Param("productionid") Integer productionid);

    int insert(Orderdetails record);

    int insertSelective(Orderdetails record);

    List<Orderdetails> selectByExample(OrderdetailsExample example);

    Orderdetails selectByPrimaryKey(@Param("orderid") Integer orderid, @Param("productionid") Integer productionid);

    int updateByExampleSelective(@Param("record") Orderdetails record, @Param("example") OrderdetailsExample example);

    int updateByExample(@Param("record") Orderdetails record, @Param("example") OrderdetailsExample example);

    int updateByPrimaryKeySelective(Orderdetails record);

    int updateByPrimaryKey(Orderdetails record);
}