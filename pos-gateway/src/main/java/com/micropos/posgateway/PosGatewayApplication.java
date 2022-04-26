package com.micropos.posgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;


@SpringBootApplication
@EnableDiscoveryClient
public class PosGatewayApplication {

	@RequestMapping("/")
	public String home(){
		return "hello gateway";
	}
	public static void main(String[] args) {
		System.setProperty("spring.config.name","gateway");
		SpringApplication.run(PosGatewayApplication.class, args);
	}

}
