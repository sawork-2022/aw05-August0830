package com.micropos.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = {"com.micropos.products.*"} )
@EnableDiscoveryClient
public class ProductsApplication {
    public static void main(String[] args) {
        System.setProperty("spring.config.name","products");
        SpringApplication.run(ProductsApplication.class, args);
    }
}