package com.itheima.controller;

import com.itheima.dao.UserMapper;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@RestController
public class MapperController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;
    @RequestMapping("/userList")
    public List<User> userList() {
        List<User> userList = userMapper.userList();
        return userList;
    }

    @RequestMapping("/findById")
    public User findById(int i) {
        User user = userMapper.findById(i);
        System.out.println(user.toString());
        return user;
    }

    @RequestMapping("/saveUser")
    public void saveUser() {
        User user = new User();
        user.setName("tom");
        user.setAge(111);
        user.setGender("男");
        user.setAddress("美国");
        user.setQq("1233444");
        user.setEmail("44444@.163.com");
        userMapper.saveUser(user);
    }

    @RequestMapping("/deleteUserById")
    public void deleteUserById() {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();
        userMapper.deleteUserById(3);
    }

    /**
     * redis
     * @return
     */
    @RequestMapping("/findByService")
    public List<User> findByService() {
        List<User> list = userService.findAll();
        return list;
    }
}
