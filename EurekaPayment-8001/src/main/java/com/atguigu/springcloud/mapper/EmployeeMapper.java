package com.atguigu.springcloud.mapper;

import com.atguigu.springcloud.entities.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author YangRuiHong
 * @create 2022-07-25 15:38
 * @email Yangrhd@dcits.com
 * @description:
 */
@Mapper
public interface EmployeeMapper {
    public List<Employee> getAll();
}
