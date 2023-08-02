package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author YangRuiHong
 * @create 2022-07-25 15:36
 * @email Yangrhd@dcits.com
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String last_name;
    private String gender;
    private String email;
}
