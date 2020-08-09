package com.jeason.mymallmbg.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: jeason
 * @Description: orders
 * @Date: 2020/7/5 10:55
 */
@Getter
@Setter
public class OrdersDto implements Serializable {
    List<String> orders;//productionid:number
}
