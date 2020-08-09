package com.jeason.inventoryApi.clients;

import com.jeason.mymallmbg.domain.CommonResult;
import com.jeason.mymallmbg.domain.OrdersDto;
import com.jeason.mymallmbg.model.Production;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: jeason
 * @Description: hello
 * @Date: 2020/7/4 23:20
 */
@FeignClient(name = "mymall-inventory",path = "/inventory")
public interface InventoryClient {

    @GetMapping("/production")
    CommonResult getProductions();

    @PostMapping("/production")
    CommonResult insertProduction(@RequestBody Production production);
    
    @PutMapping("/production")
    CommonResult updateProduction(@RequestBody Production production);

    @DeleteMapping("/production{productionId}")
    CommonResult deleteProduction(@PathVariable int productionId);

    @DeleteMapping("/production/deleteNProduction")
    CommonResult deleteNProduction(@RequestBody OrdersDto ordersDto);
    
}
