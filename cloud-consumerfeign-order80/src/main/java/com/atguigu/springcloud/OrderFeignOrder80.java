package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author YangRuiHong
 * @create 2022-06-17 12:56
 * @description:
 */
@SpringBootApplication
@EnableFeignClients
public class OrderFeignOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignOrder80.class, args);
    }
}
