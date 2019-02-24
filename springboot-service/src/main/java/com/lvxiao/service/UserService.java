package com.lvxiao.service;


import com.lvxiao.domain.User;

/**
 * Created by lvxiao on 2018/7/24.
 */
public interface UserService {

    User selectUserById(int id);

    User addUser(User user);

    User updateUser(User user);

    Integer deleteUser(Integer id);

    void testTransational();
}
