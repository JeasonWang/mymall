package com.jeason.mymalluser.controller;

import com.jeason.mymallmbg.model.User;
import com.jeason.mymalluser.common.domain.CommonResult;
import com.jeason.mymalluser.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @Author: jeason
 * @Description: userController
 * @Date: 2020/6/27 16:57
 */
@RestController
@RequestMapping("/user")
@Api(description = "user管理",tags = "userController")
public class UserController {
    @Autowired
    UserService userService;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @ApiOperation(value = "allUsers", notes = "所有用户")
    @GetMapping("/allUsers")
    public CommonResult<List<User>> allUsers(){
        return CommonResult.success(userService.allUsers());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "getUser", notes = "获取用户")
    public CommonResult<User> getUser(@PathVariable("id") Integer id){
        return CommonResult.success(userService.getUser(id));
    }

    @PostMapping("/")
    @ApiOperation(value = "createUser", notes = "添加用户")
    public CommonResult<String> createUser(@RequestBody User user){
        userService.createUser(user);
        return CommonResult.success("添加用户成功");
    }

    @PutMapping("/")
    @ApiOperation(value = "updateUser", notes = "更新用户")
    public CommonResult<String> updateUser(@RequestBody User user){
        userService.updateUser(user);
        return CommonResult.success("更新用户成功");
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "deleteUser", notes = "删除用户")
    public CommonResult<String> deleteUser(@PathVariable("id") Integer id){
        userService.deleteUser(id);
        return CommonResult.success("删除用户成功");
    }

    @GetMapping("/login")
    @ApiOperation("login")
    public CommonResult login(@RequestParam("username") String username,
                        @RequestParam("password") String password){
        return CommonResult.success(userService.login(username,password));
    }

    @GetMapping("/register")
    @ApiOperation("register")
    public String register(@RequestParam("register") String register){
        return register;
    }

    @GetMapping("/test")
    @ApiOperation("test")
    public String test(@RequestParam("test") String test){
        return test;
    }

    @ApiOperation("获取验证码")
    @RequestMapping(value = "/getAuthCode", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<String> getAuthCode(@RequestParam String telephone) {
        return userService.generateAuthCode(telephone);
    }

    @ApiOperation("判断验证码是否正确")
    @RequestMapping(value = "/verifyAuthCode", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<String> updatePassword(@RequestParam String telephone,
                                       @RequestParam String authCode) {
        return userService.verifyAuthCode(telephone,authCode);
    }
}
