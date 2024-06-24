package com.tf.dao.user;

import com.mysql.cj.util.StringUtils;
import com.tf.dao.BaseDao;
import com.tf.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao{
    @Override
    public List<User> getUserList(Connection connection, String userName, Long userRole, int currentPageNo, int pageSize) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs=null;
        List<User> userList=new ArrayList<>();
        if(connection!=null){
            StringBuffer sql=new StringBuffer("select *,smbms_role.roleName as userRoleName from smbms_user,smbms_role where smbms_user.userRole=smbms_role.id");

            List<Object> params = new ArrayList<>();
            if(!StringUtils.isNullOrEmpty(userName)){
                sql.append(" and smbms_user.userName like ?");
                params.add('%'+userName+'%');
            }
            if(userRole!=0){
                sql.append(" and  smbms_user.userRole= ?");
                params.add(userRole);
            }
            sql.append(" order by smbms_role.creationDate DESC limit ?,?");
            currentPageNo = (currentPageNo-1)*pageSize;
            params.add(currentPageNo);
            params.add(pageSize);


            System.out.println("sql ----> " + sql.toString());
//            System.out.println(currentPageNo);
//            System.out.println(pageSize);
            rs = BaseDao.execute(connection, pstm, rs, sql.toString(), params.toArray());

            while(rs.next()){
                User inListUser=new User();
                inListUser.setId(rs.getLong("id"));
                inListUser.setUserCode(rs.getString("userCode"));
                inListUser.setUserName(rs.getString("userName"));
                inListUser.setGender(rs.getInt("gender"));
                inListUser.setBirthday(rs.getDate("birthday"));
                inListUser.setPhone(rs.getString("phone"));
                inListUser.setUserRole(rs.getLong("userRole"));
//                外键处理难点======================================================
//                =======================
                inListUser.setUserRoleName(rs.getString("userRoleName"));
                inListUser.setBirthday(rs.getDate("birthday"));
//                外键处理难点=============================================================================
//                inListUser.setAge(rs.getInt("age"));
                userList.add(inListUser);
            }
            BaseDao.closeReasource(null,pstm,rs);
        }


        return userList;
    }

    @Override
    public int updatepwd(Connection connection, Long id, String pwd) throws SQLException {
        PreparedStatement pstm=null;
        if(connection!=null&& !StringUtils.isNullOrEmpty(pwd)){
//            System.out.println(id+"|"+pwd+"|1");
            String sql="update smbms_user set userPassword = ? where id=?";

            Object[] params={pwd,id};
            int execute = BaseDao.execute(connection, pstm, sql, params);

            BaseDao.closeReasource(null,pstm,null);
            return execute;
        }else {
            return 0;
        }

    }

    @Override
    public int getCount(Connection connection, String userName, Long userRole) throws SQLException {
        PreparedStatement pstm=null;
        int count=0;
        ResultSet rs=null;
        StringBuffer sql=new StringBuffer("select count(1) as count from smbms_user,smbms_role where smbms_user.userRole=smbms_role.id");
        List<Object> params=new ArrayList<>();
        if(connection!=null){
            if(!StringUtils.isNullOrEmpty(userName)){
                sql.append(" and smbms_user.userName like ?");
                params.add("%"+userName+"%");
            }
            if(userRole > 0){
                sql.append(" and  smbms_user.userRole= ?");
                params.add(userRole);
            }

            System.out.println("sql ----> " + sql.toString());
            rs = BaseDao.execute(connection, pstm, rs, sql.toString(), params.toArray());
            if(rs.next()){
                count = rs.getInt("count");
            }
            BaseDao.closeReasource(null, pstm, rs);
        }
        return count;
    }

    @Override
    public int delUser(Connection connection, Long userid) throws SQLException {
        PreparedStatement pstm=null;

        if(connection!=null&&userid!=null){
            Object[] params={userid};
            String sql="delete from smbms_user where id=?\n";
            int delete = BaseDao.execute(connection, pstm, sql, params);
            return delete;
        }
        BaseDao.closeReasource(null,pstm,null);

        return 0;
    }

    @Override
    public int addUser(Connection connection, User user) throws SQLException {
        PreparedStatement pstm=null;
        List<Object> list=new ArrayList<>();
        int effectLine=0;
        if(connection!=null){
            String sql="insert into smbms_user ( userCode, userName, userPassword, gender, birthday, phone, address, userRole, createdBy, creationDate) value (?,?,?,?,?,?,?,?,?,?)\n";
            list.add(user.getUserName());
            list.add(user.getUserCode());

            list.add(user.getUserPassword());
            list.add(user.getGender());
            list.add(user.getBirthday());
            list.add(user.getPhone());
            list.add(user.getAddress());
            list.add(user.getUserRole());
            list.add(user.getCreatedBy());
            list.add(user.getCreationDate());
            System.out.println("add"+sql);
            System.out.println(user);
            effectLine = BaseDao.execute(connection, pstm, sql, list.toArray());

        }
        BaseDao.closeReasource(null,pstm,null);
        return effectLine;
    }

    //获取User/登录对象
    public User getLoginUser(Connection connection, String userCode) throws SQLException {
        PreparedStatement pstm=null;
        ResultSet rs=null;
        Object[] params={userCode};
        User user=new User();
        String sql="select * from smbms_user where userCode=?";
        if(connection!=null){
            rs=BaseDao.execute(connection,pstm,rs,sql,params);
            if (rs.next()){

                user.setId(rs.getLong("id"));
                user.setUserCode(rs.getString("userCode"));
                user.setUserName(rs.getString("userName"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setGender(rs.getInt("gender"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setUserRole(rs.getLong("userRole"));
                user.setCreatedBy(rs.getLong("createdBy"));
                user.setCreationDate(rs.getDate("creationDate"));
                user.setModifyBy(rs.getLong("modifyBy"));
                user.setCreationDate(rs.getDate("modifyDate"));
            }


        }
        BaseDao.closeReasource(null,pstm,rs);
        return user;

    }
}
