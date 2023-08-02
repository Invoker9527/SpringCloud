package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangRuiHong
 * @create 2022-06-25 10:16
 * @description:
 */
@RestController
@Slf4j
public class NacosPaymentController {
    @RestController
    public class PaymentController {
        @Value("${server.port}")
        private String serverPort;

        @GetMapping("/payment/nacos/{id}")
        public String getPayment(@PathVariable("id") Integer id) {
            return "nacos registry,serverPort: " + serverPort + "\t id" + id;
        }
    }
}
