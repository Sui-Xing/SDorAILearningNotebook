package com.tf.service.Role;

import com.tf.dao.BaseDao;
import com.tf.dao.role.RoleDao;
import com.tf.dao.role.RoleDaoImpl;
import com.tf.pojo.Role;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao;

    public RoleServiceImpl(){
        roleDao=new RoleDaoImpl();
    }
    @Override
    public List<Role> getRoleNameList() {
        Connection connection= null;
        List<Role> roleList=null;
        connection=BaseDao.getConnection();

        if(connection!=null){

            try {
                roleList=roleDao.getRoleList(connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return roleList;




    }

    public void test(){
        List<Role> list=this.getRoleNameList();
        for (Role o : list) {
            System.out.println(o.getRoleName());


        }
    }
}
