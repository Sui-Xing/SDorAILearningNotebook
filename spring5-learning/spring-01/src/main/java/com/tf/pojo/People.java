package com.tf.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class People {

    private String name;
    @Autowired
    
    private Dog dog;
    @Autowired
    private Cat cat;
}
