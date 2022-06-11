package com.tf.dao;
import com.tf.pojo.*;

import java.util.List;

public interface UserMapper {
    public List<User> selectUserByRowBounds();
}
