package com.lvxiao.web;

import com.lvxiao.domain.User;
import com.lvxiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lvxiao on 2018/7/24.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/select")
    @ResponseBody
    public User selectUserById(Integer id) {
        return userService.selectUserById(id);
    }

    @RequestMapping("/add")
    @ResponseBody
    public User addUser(User user) {
        return userService.addUser(user);
    }

    @RequestMapping("/update")
    @ResponseBody
    public User updateUser(User user) {
        return userService.updateUser(user);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Integer deleteUser(Integer id) {
        return userService.deleteUser(id);
    }
}
