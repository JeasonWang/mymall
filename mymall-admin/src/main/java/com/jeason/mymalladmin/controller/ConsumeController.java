package com.jeason.mymalladmin.controller;

import com.jeason.mymalladmin.dto.OrdersDto;
import com.jeason.mymalladmin.service.ConsumeService;
import com.jeason.mymallmbg.domain.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: jeason
 * @Description: consume
 * @Date: 2020/7/5 10:42
 */
@RestController
@RequestMapping("/consume")
public class ConsumeController {

    @Autowired
    ConsumeService consumeService;

    @GetMapping("/getProductions")
    public CommonResult getProductions(){
        return CommonResult.success(consumeService.getProductions());
    }

    @GetMapping("/getOrders")
    public CommonResult getOrders(){
        return consumeService.getOrders();
    }

    @PostMapping("/addOrders")
    public CommonResult addOrders(@RequestBody OrdersDto ordersDto){
        return CommonResult.success(consumeService.addOrders(ordersDto));
    }

}
