package test;
import com.tf.dao.BaseDao;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Testupdate {


    @Test
    public void test() throws SQLException {
        Connection c = BaseDao.getConnection();
        String sql="update smbms_user set userPassword = ? where id=?";
        String columblable="dog";
        String sql2="select count(1) as dog from smbms_user";
        PreparedStatement pstm = c.prepareStatement(sql2);
        Long id= Long.valueOf(1);
        String pwd="bbbabb";
        Object[] params={id,pwd};
//        for (int i = 0; i <params.length ; i++) {
//            System.out.println(i+1+"||"+params[i]+"||"+"length="+params.length);
//
//            pstm.setObject(i+1,params[i]);
//
//        }
//
//        pstm.setObject(1,(Object)pwd);
//        pstm.setObject(2,(Object)id);
        ResultSet rs=pstm.executeQuery();
        while (rs.next()){
            System.out.println(rs.getInt("dog"));
        }



    }
}
