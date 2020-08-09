package com.jeason.mymallpayment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: jeason
 * @Description: payment
 * @Date: 2020/7/6 0:09
 */
@RestController
@RequestMapping("/pay")
public class PaymentController {
    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
