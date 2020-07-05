package com.jeason.mymallinventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MymallInventoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(MymallInventoryApplication.class, args);
    }

}
