package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author YangRuiHong
 * @create 2022-06-25 10:14
 * @description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosPaymentMain9003 {
    public static void main(String[] args) {
        SpringApplication.run(NacosPaymentMain9003.class, args);
    }
}
