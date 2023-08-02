package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Employee;

import java.util.List;

/**
 * @author YangRuiHong
 * @create 2022-07-25 15:40
 * @email Yangrhd@dcits.com
 * @description:
 */

public interface EmployeeService {
    public List<Employee> getAll();
}
