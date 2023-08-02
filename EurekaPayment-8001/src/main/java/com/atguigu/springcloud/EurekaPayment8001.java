package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author YangRuiHong
 * @create 2022-07-25 15:17
 * @email Yangrhd@dcits.com
 * @description:
 */
@SpringBootApplication
@EnableEurekaClient
public class EurekaPayment8001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaPayment8001.class, args);
    }
}
