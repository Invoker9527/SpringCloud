package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author YangRuiHong
 * @create 2022-07-01 12:55
 * @description:
 */
@SpringBootApplication
@EnableEurekaServer
public class Eureka7100Main {
    public static void main(String[] args) {
        SpringApplication.run(Eureka7100Main.class, args);
    }
}
