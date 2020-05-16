package com.jeason.mymalladmin.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.jeason.mymalladmin.model.AdminUserDetails;
import com.jeason.mymalladmin.service.UmsAdminService;
import com.jeason.mymallcommon.Util.JwtTokenUtil;
import com.jeason.mymallmbg.mapper.UmsAdminMapper;
import com.jeason.mymallmbg.mapper.UmsAdminRoleRelationMapper;
import com.jeason.mymallmbg.model.UmsAdmin;
import com.jeason.mymallmbg.model.UmsAdminExample;
import com.jeason.mymallmbg.model.UmsResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UmsAdminServiceImpl implements UmsAdminService, UserDetailsService {
    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UmsAdminMapper umsAdminMapper;
    @Autowired
    UmsAdminRoleRelationMapper umsAdminRoleRelationMapper;
    @Override
    public AdminUserDetails loadUserByUsername(String username) {
        UmsAdmin umsAdmin = getAdminByUsername(username);
        if (umsAdmin != null){
            List<UmsResource> umsResourceList = getResourceList(umsAdmin.getId());
            return new AdminUserDetails(umsAdmin,umsResourceList);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }

    @Override
    public List<UmsResource> getResourceList(Long adminId) {
        List<UmsResource> resourceList = null;
        if(CollUtil.isNotEmpty(resourceList)){
            return  resourceList;
        }
        resourceList = umsAdminRoleRelationMapper.getResourceList(adminId);
        if(CollUtil.isNotEmpty(resourceList)){
            //adminCacheService.setResourceList(adminId,resourceList);
        }
        return resourceList;
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        //密码需要客户端加密后传递
        try {
            UserDetails userDetails = loadUserByUsername(username);
            if(!passwordEncoder.matches(password,userDetails.getPassword())){
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
//          updateLoginTimeByUsername(username);
        } catch (AuthenticationException e) {
            log.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    @Override
    public UmsAdmin getAdminByUsername(String username) {
        UmsAdmin umsAdmin = null;;
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<UmsAdmin> umsAdminList = umsAdminMapper.selectByExample(example);
        if (umsAdminList != null && umsAdminList.size() > 0){
            umsAdmin = umsAdminList.get(0);
            return umsAdmin;
        }
        return null;
    }


}
