package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Employee;
import com.atguigu.springcloud.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author YangRuiHong
 * @create 2022-07-25 15:33
 * @email Yangrhd@dcits.com
 * @description:
 */

@Controller
public class EurekaController {
    @Autowired
    private EmployeeService employeeService;
    @Value("${server.port}")
    public String ServerPort;

    @GetMapping("/getAll")
    public List<Employee> getInfo() {

        return employeeService.getAll();
    }
}
