package com.tf.dao.user;

import com.tf.pojo.User;
import com.tf.util.Constant;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
//    获取登录用户
    public User getLoginUser(Connection connection, String userCode)throws Exception;
//    修改密码
    public int updatepwd(Connection connection,Long id,String pwd) throws SQLException;
//    获取用户列表
    public List<User> getUserList(Connection connection,String userName,Long userRole,int currentPageNo,int pageSize) throws SQLException;
//    获取用户列表用户总数
    public int getCount(Connection connection,String userName,Long userRole) throws SQLException;
//    增加用户
    public int addUser(Connection connection,User user) throws SQLException;
//    删除用户
    public int delUser(Connection connection,Long userid) throws SQLException;
}


