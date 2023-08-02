package com.atguigu.springcloud.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Repository;

/**
 * @Author YangRuiHong
 * @Create 2022-02-24 11:14
 * @Description
 */
@Repository
@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {
    private String name;
    private int age;
    private String sex;

    public void say() {
        System.out.println("say");
    }
}
