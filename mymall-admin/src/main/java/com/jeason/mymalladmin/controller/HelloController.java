package com.jeason.mymalladmin.controller;

import com.jeason.mymalladmin.dto.UmsAdminLoginParam;
import com.jeason.mymalladmin.service.UmsAdminService;
import com.jeason.mymallcommon.api.CommonResult;
import com.jeason.mymallmbg.model.UmsAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {
    @Autowired
    UmsAdminService umsAdminService;

    @GetMapping("/hello")
    public String hello(){
        UmsAdmin umsAdmin = umsAdminService.getAdminByUsername("admin");
        System.out.println(umsAdmin.getUsername());
        return "hello";
    }


}
