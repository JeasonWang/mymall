package com.jeason.mymalladmin.service;

import com.jeason.mymalladmin.model.AdminUserDetails;
import com.jeason.mymallmbg.model.UmsAdmin;
import com.jeason.mymallmbg.model.UmsResource;

import java.util.List;

public interface UmsAdminService {
    AdminUserDetails loadUserByUsername(String username);
    UmsAdmin getAdminByUsername(String username);
    List<UmsResource> getResourceList(Long adminId);
}
