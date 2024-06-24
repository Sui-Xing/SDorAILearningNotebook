package com.tf.dao.role;

import com.tf.pojo.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface RoleDao {
    //    获取角色list
    public List<Role> getRoleList(Connection connection) throws SQLException;
}
