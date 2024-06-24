import com.tf.dao.StudentMapper;
import com.tf.dao.TeacherMapper;
import com.tf.dao.UserMapper;
import com.tf.pojo.Student;
import com.tf.pojo.Teacher;
import com.tf.pojo.User;
import com.tf.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class Test_1 {
    @Test
    public void Test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teacher = mapper.getTeacher(1);
        for (Teacher teacher1 : teacher) {
            System.out.println(teacher1);

        }

    }

    @Test
    public void TestRowBounds(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        RowBounds rowBounds = new RowBounds(0, 5);


        List<User> userList = sqlSession.selectList("com.tf.dao.UserMapper.selectUserByRowBounds", null, rowBounds);
        for (User user : userList) {
            System.out.println(user);

        }

    }
    @Test
    public void Test3(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> studentList= mapper.getStudent_3();
        for (Student student : studentList) {
            System.out.println(student);

        }

    }


}
