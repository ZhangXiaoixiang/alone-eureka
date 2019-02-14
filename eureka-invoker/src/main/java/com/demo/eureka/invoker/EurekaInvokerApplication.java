package com.demo.eureka.invoker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaInvokerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaInvokerApplication.class, args);
        System.out.println("服务调用者:http://localhost:9000/router");
        System.out.println("服务实例列表:http://localhost:9000/router2");
    }

}

