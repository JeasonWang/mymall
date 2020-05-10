package com.jeason.mymalladmin.controller;

import com.jeason.mymalladmin.service.UmsAdminService;
import com.jeason.mymallmbg.model.UmsAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    UmsAdminService umsAdminService;

    @GetMapping("/hello")
    public String hello(){
        UmsAdmin umsAdmin = umsAdminService.loadUserByUsername("admin");
        System.out.println(umsAdmin.getNickName());
        return "hello";
    }
}
