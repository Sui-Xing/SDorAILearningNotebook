package com.tf.dao.role;

import com.tf.dao.BaseDao;
import com.tf.pojo.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl implements RoleDao{


    //    获取角色list
    @Override


    public List<Role> getRoleList(Connection connection) throws SQLException {
        List<Role> roleList=new ArrayList<>();
        PreparedStatement pstm=null;
        ResultSet rs=null;
        if(connection!=null){
            String sql="select * from smbms_role";
            Object[] params = {};
            rs=BaseDao.execute(connection,pstm,rs,sql,params);
            while (rs.next()){
                Role role = new Role();
                role.setId(rs.getLong("id"));
                role.setRoleCode(rs.getString("roleCode"));
                role.setRoleName(rs.getString("roleName"));
                role.setCreatedBy(rs.getLong("createdBy"));
                role.setCreationDate(rs.getDate("creationDate"));
                role.setModifyBy(rs.getLong("modifyBy"));
                role.setModeifyDate(rs.getDate("modifyDate"));
                roleList.add(role);

            }
        }
        BaseDao.closeReasource(null,pstm,rs);
        return roleList;


    }

}

