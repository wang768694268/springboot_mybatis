package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public List<User> userList();
    public User findById(Integer id);

    public void saveUser(User user);

    void deleteUserById(int i);
}
