package com.project.pms.leaveservice;

import org.springframework.boot.SpringApplication;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class LeaveServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationTests.class, args);
    }

}