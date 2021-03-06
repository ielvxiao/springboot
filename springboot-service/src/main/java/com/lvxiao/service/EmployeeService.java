package com.lvxiao.service;


import com.lvxiao.domain.Employee;

import java.util.List;

/**
 * Created by lvxiao on 2018/9/3.
 */
public interface EmployeeService {
    List<Employee> selectAllEmployees();
    Employee selectEmployeeById(int id);
    Employee test(int id);
    List<Employee> selectEmployeeByIds(List<Integer> ids);
}
