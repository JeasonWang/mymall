package com.jeason.mymalladmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.jeason.orderApi","com.jeason.inventoryApi"})
public class MymallAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(MymallAdminApplication.class, args);
    }

}
