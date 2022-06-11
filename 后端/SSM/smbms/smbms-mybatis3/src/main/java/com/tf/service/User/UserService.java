package com.tf.service.User;

import com.tf.pojo.User;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.util.List;

public interface UserService{
//    登录判断
    public User login(String userCode, String userPassword) throws Exception;
//    根据id修改密码
    public boolean updatePwd(Long id, String pwd);
//    获取用户列表
    public List<User> getUserList(String userName, Long userRole, int currentPageNo, int pageSize);
//    获取用户总数
    public int  getCount(String userName, Long userRole);
//    添加用户
    public int addUser(User user);

    public User selectUserCodeExist(String userCode);

    public boolean delUser(Long userid);
}