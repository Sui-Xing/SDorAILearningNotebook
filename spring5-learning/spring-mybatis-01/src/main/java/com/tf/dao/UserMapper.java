package com.tf.dao;
import com.tf.pojo.User;

import java.util.List;

public interface UserMapper {
    public List<User> selectUser();
}