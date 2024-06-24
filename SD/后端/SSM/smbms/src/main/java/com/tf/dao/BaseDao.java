package com.tf.dao;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class BaseDao {
    static {
        init();
    }
    private static String driver;
    private static String url;
    private static String username;
    private static String password;


    public static void init(){
        Properties properties = new Properties();
        String configpath="db.properties";
        InputStream is = BaseDao.class.getClassLoader().getResourceAsStream(configpath);
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver=properties.getProperty("driver");
        url=properties.getProperty("url");
        username=properties.getProperty("user");
        password=properties.getProperty("password");

    }


//    获取数据库链接
    public static Connection getConnection(){
        Connection connection=null;
        try {
            Class.forName(driver);
            connection= DriverManager.getConnection(url,username,password);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

//    查询操作
    public static ResultSet execute(Connection connection, PreparedStatement pstm,ResultSet rs,
                                    String sql,Object[] params) throws SQLException {
        pstm=connection.prepareStatement(sql);

        for (int i = 0; i < params.length; i++) {
            pstm.setObject(i+1,params[i]);

        }
        rs=pstm.executeQuery();
        return rs;
    }
//    更新操作
    public static int execute(Connection connection,PreparedStatement pstm,
                              String sql,Object[] params) throws SQLException {
        pstm=connection.prepareStatement(sql);
        for (int i = 0; i <params.length ; i++) {
            pstm.setObject(i+1,params[i]);

        }
        int i=0;


        int count=pstm.executeUpdate();
        System.out.println(count);
        return count;
    }
//    释放资源
    public static boolean closeReasource(Connection connection,PreparedStatement pstm,ResultSet rs){
        boolean flag=true;
        if(rs!=null){
            try {
                rs.close();
                rs=null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag=false;
            }
        }
        if(pstm!=null){
            try {
                pstm.close();
                pstm=null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag=false;
            }
        }
        if(connection!=null){
            try {
                connection.close();
                connection=null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag=false;
            }
        }
        return flag;
    }

}


