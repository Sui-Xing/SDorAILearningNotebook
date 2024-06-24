package com.tf.service.User;

import com.mysql.cj.util.StringUtils;
import com.tf.dao.BaseDao;
import com.tf.dao.user.UserDao;

import com.tf.pojo.User;
import com.tf.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;


import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService{

    @Override
    public List<User> getUserList(String userName, Long userRole, int currentPageNo, int pageSize) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        currentPageNo=(currentPageNo-1)*pageSize;
        List<User> userList= null;
        try {
            userList = userDao.getUserList(userName,userRole,currentPageNo,pageSize);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return userList;
    }

    //    根据id修改密码
    @Override
    public boolean updatePwd(Long id, String pwd) {

        int updatepwd=0;
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        try {
            updatepwd = userDao.updatepwd(id, pwd);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        if(updatepwd>0){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public User selectUserCodeExist(String userCode) {
        // TODO Auto-generated method stub
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = null;
        try {
            user = userDao.getLoginUser(userCode);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public boolean delUser(Long userid) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        boolean flag=false;
        if(userid!=null){
            int i = 0;
            try {
                i = userDao.delUser(userid);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            if(i>0){
                flag=true;
            }
        }
        return flag;
    }

    @Override
    public int addUser(User user) {

        int effectLine=0;
//        这里处理user还是dao层处理
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        try {
            effectLine = userDao.addUser(user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return effectLine;
    }

    //登录判断
    @Override
    public User login(String userCode, String userPassword) throws Exception {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.getLoginUser(userCode);

        if(user!=null&&user.getUserPassword().equals(userPassword)){
            return user;
        }else {
            return null;
        }




    }

    @Override
    public int getCount(String userName, Long userRole) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        int count = 0;
        try {
            count = userDao.getCount(userName, userRole);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return count;
    }


    public void test() throws Exception {
//        Connection connection=null;
//        BaseDao.closeReasource(connection,null,null);
//        System.out.println(connection);
        List<User> count=this.getUserList("", (long) 0,1,5);
        for (User user : count) {
//            System.out.println(user.getUserName());
        }
    }
}
