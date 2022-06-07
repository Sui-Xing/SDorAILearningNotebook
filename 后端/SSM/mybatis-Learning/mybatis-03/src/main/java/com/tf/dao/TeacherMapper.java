package com.tf.dao;

import com.tf.pojo.Teacher;

import java.util.List;

public interface TeacherMapper {
    List<Teacher> getTeacher(int id);
}
