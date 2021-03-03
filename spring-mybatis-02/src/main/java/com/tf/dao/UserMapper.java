package com.tf.dao;
import com.tf.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("select * from user")
    public List<User> selectUser();
}