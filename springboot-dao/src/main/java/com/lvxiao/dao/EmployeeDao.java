package com.lvxiao.dao;


import com.lvxiao.domain.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lvxiao on 2018/9/3.
 */
@Repository
public interface EmployeeDao {
    List<Employee> selectAllEmployees();

    Employee selectEmployeeById(int id);

    Employee test(int id);

    List<Employee> selectEmployeeByIds(List<Integer> ids);
}
