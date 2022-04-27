package com.micropos.carts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = {"com.micropos.carts.*"} )
@EnableDiscoveryClient
public class CartsApplication {
    public static void main(String[] args){
        System.setProperty("spring.config.name","carts");
		SpringApplication.run(CartsApplication.class, args);
    }
}