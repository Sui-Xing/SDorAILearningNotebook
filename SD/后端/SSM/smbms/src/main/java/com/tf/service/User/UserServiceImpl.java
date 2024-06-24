package com.tf.service.User;

import com.mysql.cj.util.StringUtils;
import com.tf.dao.BaseDao;
import com.tf.dao.user.UserDao;
import com.tf.dao.user.UserDaoImpl;
import com.tf.pojo.User;
import org.junit.Test;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }


    @Override
    public List<User> getUserList(String userName, Long userRole, int currentPageNo, int pageSize) {

        Connection connection=BaseDao.getConnection();
        List<User> userList=new ArrayList<>();
        if(connection!=null){
            try {
//                System.out.println(currentPageNo);
                userList=userDao.getUserList(connection,userName,userRole,currentPageNo,pageSize);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        BaseDao.closeReasource(connection,null,null);

        return userList;
    }

    //    根据id修改密码
    @Override
    public boolean updatePwd(Long id, String pwd) {
        BaseDao baseDao=new BaseDao();
        Connection connection = baseDao.getConnection();
//        System.out.println();
        int updatepwd=0;
        try {
            if(connection!=null&&!StringUtils.isNullOrEmpty(pwd)){

                updatepwd = userDao.updatepwd(connection, id, pwd);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            baseDao.closeReasource(connection,null,null);
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
        Connection connection = null;
        User user = null;
        try {
            connection = BaseDao.getConnection();
            user = userDao.getLoginUser(connection, userCode);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeReasource(connection, null, null);
        }
        return user;
    }

    @Override
    public boolean delUser(Long userid) {
        Connection connection = BaseDao.getConnection();
        boolean flag=false;
        if(connection!=null&&userid!=null){
            try {
                connection.setAutoCommit(false);
                int delcount = userDao.delUser(connection, userid);
                connection.commit();
                if(delcount>0){
                    flag=true;
                    System.out.println("删除成功");
                }else {
                    System.out.println("删除失败");

                }


            } catch (SQLException throwables) {
                throwables.printStackTrace();

                try {
                    connection.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }finally {
                BaseDao.closeReasource(connection,null,null);
            }

        }
        return flag;
    }

    @Override
    public int addUser(User user) {
        Connection connection = BaseDao.getConnection();
        int effectLine=0;
//        这里处理user还是dao层处理

        if(connection!=null){
            try {
                connection.setAutoCommit(false);
                effectLine = userDao.addUser(connection, user);
                connection.commit();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                try {
                    connection.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }finally {
                BaseDao.closeReasource(connection,null,null);
            }
        }
        return effectLine;
    }

    //登录判断
    @Override
    public User login(String userCode, String userPassword) throws Exception {
//        利用反射获取connection
        Class<BaseDao> bdc = BaseDao.class;
        Method conMethod = bdc.getDeclaredMethod("getConnection");
        Method closeReasource = bdc.getMethod("closeReasource", Connection.class, PreparedStatement.class, ResultSet.class);
        BaseDao baseDao = bdc.newInstance();
        Connection connection= (Connection) conMethod.invoke(baseDao);

//        利用接口获取getloginUser方法
        User user = userDao.getLoginUser(connection, userCode);
        closeReasource.invoke(baseDao,connection,null,null);
//        System.out.println(user.toString());
        if(user!=null&&user.getUserPassword().equals(userPassword)){
            return user;
        }else {
            return null;
        }




    }

    @Override
    public int getCount(String userName, Long userRole) {
        Connection connection = BaseDao.getConnection();
        int count=0;
        if(connection!=null){

            try {
                count=userDao.getCount(connection,userName,userRole);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        BaseDao.closeReasource(connection,null,null);
        return count;
    }

    @Test
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
