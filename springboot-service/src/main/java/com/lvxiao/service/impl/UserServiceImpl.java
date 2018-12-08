package com.lvxiao.service.impl;

import com.lvxiao.dao.UserDao;
import com.lvxiao.domain.User;
import com.lvxiao.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by lvxiao on 2018/7/24.
 */
@Service()
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @CachePut(value = "User", key = "'User' + #user.id", condition = "#result != null")
    public User updateUser(User user) {
        userDao.updateUser(user);
        return userDao.selectUserById(user.getId());
    }

    @CacheEvict(value = "User", beforeInvocation=true, key = "'User' + #id")
    public Integer deleteUser(Integer id) {
        return userDao.deleteUser(id);
    }

    /**
     * 通过ID查询用户
     * @param id
     * @return
     */
    @Cacheable(value = "User",key = "'User' + #id")
    public User selectUserById(int id) {
        LOGGER.debug("id为{}",id);
        return userDao.selectUserById(id);
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @CachePut(value = "User", key = "'User' + #user.id", condition = "#result != null")
    public User addUser(User user) {
        LOGGER.debug("添加的用户id为{}",user.getId());
        int rows = userDao.addUser(user);
        LOGGER.debug("更新了{}行",rows);
        return userDao.selectUserById(user.getId());
    }
}
