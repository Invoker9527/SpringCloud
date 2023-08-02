package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.entities.Employee;
import com.atguigu.springcloud.mapper.EmployeeMapper;
import com.atguigu.springcloud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YangRuiHong
 * @create 2022-07-25 15:41
 * @email Yangrhd@dcits.com
 * @description:
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAll() {
        return employeeMapper.getAll();
    }
}
