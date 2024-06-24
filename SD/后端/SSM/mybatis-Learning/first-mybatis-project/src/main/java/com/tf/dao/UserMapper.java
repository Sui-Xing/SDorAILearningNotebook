package com.tf.dao;

import com.tf.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> getUserList();
    int addUser(User user);
}
