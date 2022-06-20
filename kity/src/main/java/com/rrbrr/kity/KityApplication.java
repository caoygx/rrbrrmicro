package com.rrbrr.kity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableDiscoveryClient
@MapperScan("com.rrbrr.kity.mapper")
public class KityApplication {
    public static void main(String[] args) {
        SpringApplication.run(KityApplication.class,args);
    }
}
