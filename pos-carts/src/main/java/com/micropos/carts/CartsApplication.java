package com.micropos.carts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CartsApplication {
    public static void main(String[] args){
        System.setProperty("spring.config.name","carts");
		SpringApplication.run(CartsApplication.class, args);
    }
}