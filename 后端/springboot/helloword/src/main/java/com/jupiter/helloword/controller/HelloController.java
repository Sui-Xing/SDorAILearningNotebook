package com.jupiter.helloword.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//本身就是Spring的组件
@RestController
public class HelloController {

    //接口： http://localhost:8080/hello
    @RequestMapping("/hello")
    public String hello(){

        return "helloworld";
    }

}
