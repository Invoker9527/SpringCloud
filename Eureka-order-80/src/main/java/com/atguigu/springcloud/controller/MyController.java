package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author YangRuiHong
 * @create 2022-07-25 16:23
 * @email Yangrhd@dcits.com
 * @description:
 */
@RestController
public class MyController {
    public static final String PAYMENT_URL = "http://localhost:8001"; //单机版
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getAll")
    @ResponseBody
    public CommonResult getInfo() {
        return restTemplate.getForObject(PAYMENT_URL + "/getAll", CommonResult.class);
    }
}
