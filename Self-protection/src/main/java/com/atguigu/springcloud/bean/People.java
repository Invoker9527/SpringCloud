package com.atguigu.springcloud.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @Author YangRuiHong
 * @Create 2022-02-24 11:33
 * @Description
 */


@Component("people")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class People {
    private int id;

    private User user;
}
