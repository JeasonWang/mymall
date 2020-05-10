package com.jeason.mymalladmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.jeason.mymallmbg.mapper")
public class MymallAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(MymallAdminApplication.class, args);
    }

}
