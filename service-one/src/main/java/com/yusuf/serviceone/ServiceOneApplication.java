package com.yusuf.serviceone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceOneApplication.class, args);
    }

}
