package com.jeason.mymalladmin.controller;

import com.jeason.mymalladmin.dto.UmsAdminLoginParam;
import com.jeason.mymalladmin.service.UmsAdminService;
import com.jeason.mymallcommon.api.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@RestController
@Api(value = "/login",tags = "登录接口")
public class LoginController {
    @Autowired
    UmsAdminService umsAdminService;

    @ApiOperation(value = "login",httpMethod = "POST",notes = "登录请求")
    @PostMapping("/login")
    public CommonResult login(@RequestBody UmsAdminLoginParam umsAdminLoginParam){
        String token = umsAdminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        System.out.println();
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        return CommonResult.success(tokenMap);
    }
}
