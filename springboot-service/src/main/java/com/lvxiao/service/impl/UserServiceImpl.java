package com.lvxiao.service.impl;

import com.lvxiao.dao.UserDao;
import com.lvxiao.domain.User;
import com.lvxiao.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
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

    //更新数据后，更新缓存，如果 condition 配置项使结果返回为 null ，不缓存
    @CachePut(value = "User", key = "'User' + #result.id", condition = "#result != null")
    public User updateUser(User user) {
        //此处调用 getUser 方法，该方法缓存注解失效 ，
        //所以这里还会执行 SQL ，将查询到数据库最新数据
        User user1 = this.selectUserById(user.getId());
        if (user1 == null) {
            return null;
        }
        userDao.updateUser(user);
        return user;
    }

    //删除数据,移除缓存
    @CacheEvict(value = "User", beforeInvocation = false, key = "'User' + #id")
    public Integer deleteUser(Integer id) {
        return userDao.deleteUser(id);
    }

    /**
     * 通过ID查询用户
     *可指定cacheManager
     * @param id
     * @return
     */
    @Cacheable(value = "User", key = "'User' + #id",cacheManager = "cacheManagerHours")
    public User selectUserById(int id) {
        LOGGER.debug("id为{}", id);
        return userDao.selectUserById(id);
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @CachePut(value = "User", key = "'User' + #result.id")
    public User addUser(User user) {
        LOGGER.debug("添加的用户id为{}", user.getId());
        int rows = userDao.addUser(user);
        LOGGER.debug("更新了{}行", rows);
        return userDao.selectUserById(user.getId());
    }
}
