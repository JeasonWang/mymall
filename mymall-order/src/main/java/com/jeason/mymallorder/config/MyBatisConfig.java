package com.jeason.mymallorder.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: jeason
 * @Description: mybatis config
 * @Date: 2020/7/4 23:40
 */
@Configuration
@MapperScan("com.jeason.mymallmbg.mapper")
public class MyBatisConfig {
}
