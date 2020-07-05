package com.jeason.mymalluser.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: jeason
 * @Description: MyBatis配置类
 * @Date: 2020/6/27 16:40
 */
@Configuration
@MapperScan(basePackages = {"com.jeason.mymallmbg.mapper","com.jeason.mymalluser.mapper"})
public class MyBatisConfig {
}
