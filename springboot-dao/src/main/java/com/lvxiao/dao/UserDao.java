package com.lvxiao.dao;


import com.lvxiao.domain.User;
import org.springframework.stereotype.Repository;

/**
 * Created by lvxiao on 2018/7/24.
 */
@Repository
public interface UserDao {
    User selectUserById(int id);

    Integer addUser(User user);

    Integer updateUser(User user);

    Integer deleteUser(Integer id);
}
