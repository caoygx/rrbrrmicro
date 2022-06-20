package com.rrbrr.kityclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class KityClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(com.rrbrr.kityclient.KityClientApplication.class,args);
    }
}
