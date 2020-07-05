package com.jeason.mymalluser.mapper;

import com.jeason.mymallmbg.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserMapper {
    User getUserByName(String name);
}