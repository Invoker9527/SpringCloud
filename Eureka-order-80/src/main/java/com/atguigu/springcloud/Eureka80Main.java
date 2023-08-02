package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author YangRuiHong
 * @create 2022-07-25 15:55
 * @email Yangrhd@dcits.com
 * @description:
 */
@SpringBootApplication
@EnableEurekaClient
public class Eureka80Main {
    public static void main(String[] args) {
        SpringApplication.run(Eureka80Main.class, args);
    }
}
