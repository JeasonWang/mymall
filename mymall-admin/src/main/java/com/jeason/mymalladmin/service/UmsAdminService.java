package com.jeason.mymalladmin.service;

import com.jeason.mymallmbg.model.UmsAdmin;

public interface UmsAdminService {
    UmsAdmin loadUserByUsername(String username);
}
