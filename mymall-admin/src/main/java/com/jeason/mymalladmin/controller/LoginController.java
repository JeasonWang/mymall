package com.jeason.mymalladmin.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
@RestController
@Api(value = "/login",tags = "登录接口")
public class LoginController {
//    @Autowired
//    UmsAdminService umsAdminService;
//
//    @ApiOperation(value = "login",httpMethod = "POST",notes = "登录请求")
//    @PostMapping("/login")
//    public CommonResult login(@RequestBody UserLoginDto userLoginDto){
//        String token = umsAdminService.login(userLoginDto.getUsername(), userLoginDto.getPassword());
//        if (token == null) {
//            return CommonResult.validateFailed("用户名或密码错误");
//        }
//        System.out.println();
//        Map<String, String> tokenMap = new HashMap<>();
//        tokenMap.put("token", token);
//        return CommonResult.success(tokenMap);
//    }

}
