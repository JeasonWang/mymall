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

    @GetMapping("/test")
    public String test(){
        return "test";
    }


    @PostMapping("/inventoryClient")
    public CommonResult inventoryClient(@RequestBody OrdersDto ordersDto){
        return CommonResult.success(consumeService.hello1());
    }

    @PostMapping("/ordersClient")
    public CommonResult ordersClient(@RequestBody OrdersDto ordersDto){
        return CommonResult.success(consumeService.hello2());
    }

    @PostMapping("/getProductions")
    public CommonResult getProductions(@RequestBody OrdersDto ordersDto){
        return CommonResult.success(consumeService.getProductions());
    }

    @PostMapping("/getOrders")
    public CommonResult getOrders(@RequestBody OrdersDto ordersDto){
        return CommonResult.success(consumeService.getOrders());
    }

    @GetMapping("/getOrderById{ordersId}")
    public CommonResult getOrderById(@PathVariable int ordersId){
        System.out.println(ordersId);
        return consumeService.getOrderById(ordersId);
    }
}
