package com.tf.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//代表这个类会被Spring接管，
// 这个注解的类中的所有方法如果返回方法是String，并且有具体的页面进行跳转，那么就会被视图解析器解析
//@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("/hello")
    public String hello(Model model){
        //封装数据
        model.addAttribute("msg","SpringMVC Annotation");
        return "hello";//会被视图解析器处理
    }
}
