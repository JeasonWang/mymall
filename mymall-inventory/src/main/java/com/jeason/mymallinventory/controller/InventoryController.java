package com.jeason.mymallinventory.controller;

import com.jeason.mymallinventory.service.ProductionService;
import com.jeason.mymallmbg.domain.CommonResult;
import com.jeason.mymallmbg.model.Production;
import com.jeason.mymallmbg.model.Production;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: jeason
 * @Description: hello
 * @Date: 2020/7/4 23:20
 */
@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    ProductionService productionService;
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/production")
    public List<Production> getProductions(){
        return productionService.getProductions();
    }

    @PostMapping("/production")
    public CommonResult insertProduction(@RequestBody Production production){
        return CommonResult.success(productionService.insertProduction(production));
    }

    @PutMapping("/production")
    public CommonResult updateProduction(@RequestBody Production production){
        return CommonResult.success(productionService.updateProduction(production));
    }

    @DeleteMapping("/production{productionId}")
    public CommonResult deleteProduction(@PathVariable int productionId){
        return CommonResult.success(productionService.deleteProduction(productionId));
    }
}
