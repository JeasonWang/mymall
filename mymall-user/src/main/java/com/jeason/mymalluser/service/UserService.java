package com.jeason.mymalluser.service;

import com.jeason.mymallmbg.mapper.UserMapper;
import com.jeason.mymallmbg.model.User;
import com.jeason.mymalluser.common.domain.CommonResult;
import com.jeason.mymalluser.common.service.RedisService;
import com.jeason.mymalluser.mapper.MyUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Random;

/**
 * @Author: jeason
 * @Description: UserService
 * @Date: 2020/6/27 16:59
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    MyUserMapper myUserMapper;

    @Autowired
    private RedisService redisService;

    private final String REDIS_KEY_PREFIX_AUTH_CODE = "portal:authCode:";
    private final Long AUTH_CODE_EXPIRE_SECONDS = 120L;

    public List<User> allUsers(){
        return userMapper.selectByExample(null);
    }

    public User getUser(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }

    public User getUserByName(String name){
        return myUserMapper.getUserByName(name);
    }

    public String login(String username,String password){
        User user = getUserByName(username);
        if (password.equals(user.getPassword())){
            return "登录成功";
        }
        return "登录失败";
    }

    public int createUser(User user){
        int result = userMapper.insert(user);
        if (result == 0){
            throw new RuntimeException("添加User失败");
        }
        return result;
    }

    public int deleteUser(Integer id){
        int result = userMapper.deleteByPrimaryKey(id);
        if (result == 0){
            throw new RuntimeException("删除User失败");
        }
        return result;
    }

    public int updateUser(User user){
        int result = userMapper.updateByPrimaryKeySelective(user);
        if (result == 0){
            throw new RuntimeException("更新User失败");
        }
        return result;
    }

    public CommonResult<String> generateAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        //验证码绑定手机号并存储到redis
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + telephone, sb.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + telephone, AUTH_CODE_EXPIRE_SECONDS);
        return CommonResult.success(sb.toString(), "获取验证码成功");
    }

    public CommonResult<String> verifyAuthCode(String telephone, String authCode) {
        if (StringUtils.isEmpty(authCode)) {
            return CommonResult.failed("请输入验证码");
        }
        String realAuthCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + telephone);
        boolean result = authCode.equals(realAuthCode);
        if (result) {
            return CommonResult.success(null, "验证码校验成功");
        } else {
            return CommonResult.failed("验证码不正确");
        }
    }
}
