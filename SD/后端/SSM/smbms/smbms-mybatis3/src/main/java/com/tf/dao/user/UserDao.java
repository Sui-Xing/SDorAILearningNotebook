package com.tf.dao.user;

import com.tf.pojo.User;
import com.tf.util.Constant;
import org.apache.ibatis.annotations.Param;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
//    获取登录用户
    public User getLoginUser(String userCode)throws Exception;
//    修改密码
    public int updatepwd(@Param("id") Long id, @Param("pwd")String pwd) throws SQLException;
//    获取用户列表
    public List<User> getUserList(@Param("userName")String userName, @Param("userRole")Long userRole,@Param("currentPageNo") int currentPageNo,@Param("pageSize") int pageSize) throws SQLException;
//    获取用户列表用户总数
    public int getCount(@Param("userName")String userName,@Param("userRole") Long userRole) throws SQLException;
//    增加用户
    public int addUser(User user) throws SQLException;
//    删除用户
    public int delUser(@Param("userid")Long userid) throws SQLException;

    void getLoginUser();
}


