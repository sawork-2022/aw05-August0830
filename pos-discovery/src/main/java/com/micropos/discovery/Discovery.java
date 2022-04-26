package com.micropos.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Discovery {
    private static final String DISCOVERY_SERVER_HOSTNAME = "discovery.server.hostname";
    public static void main(String[] args)
    {
        System.setProperty("spring.config.name","discovery");
        SpringApplication.run(Discovery.class,args);
    }
}