package com.atguigu.springcloud.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author YangRuiHong
 * @Create 2022-02-24 14:14
 * @Description
 */
@Configuration
@ComponentScan(basePackages = {"com.atguigu.springcloud"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringConfig {
}
