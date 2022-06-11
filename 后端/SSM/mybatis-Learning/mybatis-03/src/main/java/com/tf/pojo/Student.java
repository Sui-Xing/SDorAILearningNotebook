package com.tf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("Student")
public class Student {
    private int id;
    private String name;
    private int tid;
    private Teacher teacher;
}
