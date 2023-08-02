package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author YangRuiHong
 * @create 2022-06-15 21:44
 * @description:
 */
@RestController
@Slf4j
public class OrderZkController {
    public static final String INVOKER_URL = "http://cloud-provider-payment";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String paymentInfo() {
        //第二个参数是返回值类型
        String result = restTemplate.getForObject(INVOKER_URL + "/payment/zk", String.class);
        return result;
    }

}
