package com.dmeo.eureka.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EurekaProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaProviderApplication.class, args);
        System.out.println("服务提供者first-service-provider");
        System.out.println("模拟数据库状态: http://localhost:8080/db/true");
    }

}

