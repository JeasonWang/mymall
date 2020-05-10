package com.jeason.mymalladmin.service.impl;

import com.jeason.mymalladmin.service.UmsAdminService;
import com.jeason.mymallmbg.mapper.UmsAdminMapper;
import com.jeason.mymallmbg.model.UmsAdmin;
import com.jeason.mymallmbg.model.UmsAdminExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UmsAdminServiceImpl implements UmsAdminService {
    @Autowired
    UmsAdminMapper umsAdminMapper;
    @Override
    public UmsAdmin loadUserByUsername(String username) {
        UmsAdmin umsAdmin = null;
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
