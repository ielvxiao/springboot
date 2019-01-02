package com.lvxiao.service.impl;

import com.lvxiao.dao.employee.DepartmentsDao;
import com.lvxiao.domain.Departments;
import com.lvxiao.service.DepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lvxiao on 2018/9/7.
 */
@Service
public class DepartmentsServiceImpl implements DepartmentsService {

    @Autowired
    private DepartmentsDao departmentsDao;

    @Override
    public Departments selectDepartmentById(String id) {
        return departmentsDao.selectDepartmentById(id);
    }
}
