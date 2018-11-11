package com.itheima.service;

import com.itheima.dao.UserMapper;
import com.itheima.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private UserMapper userMapper;

    public List<User> findAll() {
        List<User> userList = userMapper.userList();

        return userList;
    }

}
