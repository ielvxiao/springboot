package com.lvxiao.dao.employee;


import com.lvxiao.domain.Departments;
import org.springframework.stereotype.Repository;

/**
 * Created by lvxiao on 2018/9/7.
 */
@Repository
public interface DepartmentsDao {
    Departments selectDepartmentById(String dept_no);
}
