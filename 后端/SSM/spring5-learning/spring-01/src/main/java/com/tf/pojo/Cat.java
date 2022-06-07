package com.tf.pojo;

import lombok.Data;

@Data
public class Cat {
    private String name;
    public void dosth(){
        System.out.println("miao~");
    }
}
