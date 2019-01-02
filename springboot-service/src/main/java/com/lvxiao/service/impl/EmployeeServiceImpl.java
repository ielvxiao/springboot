package com.lvxiao.service.impl;

import com.lvxiao.dao.employee.EmployeeDao;
import com.lvxiao.domain.Employee;
import com.lvxiao.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by lvxiao on 2018/9/3.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    public static final String CACHE_NAME = "employee";
    @Autowired
    private EmployeeDao employeeDao;

//    @Autowired
//    @Qualifier(value = "UserCache")
//    private RedisCache redisCache;


    @Cacheable(value = "Employee", key = "#ids")
    @Override
    public List<Employee> selectEmployeeByIds(List<Integer> ids) {
        List<Employee> employees = employeeDao.selectEmployeeByIds(ids);
        return employees;
    }

    @Cacheable(value = "Employee",key = "'Employee' + #id")
    @Override
    public Employee  selectEmployeeById(int id) {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return employeeDao.selectEmployeeById(id);
    }

    @Cacheable(value = "Employee",key = "'Employee' + #id")
    @Override
    public Employee test(int id) {
        System.out.println("这个是测试对比");
        return employeeDao.test(id);
    }

    @Override
    public List<Employee> selectAllEmployees() {
        return employeeDao.selectAllEmployees();
    }
}
