package com.tf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.tf.pojo.User;
@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/t1")
    public String test1(@RequestParam("username") String name, Model model){
        // 1.接受前端参数
        System.out.println("接收到前端的参数为"+name);

        // 2.将返回的结果传递给前端
        model.addAttribute("msg",name);
        return "hello";

    }

    // 前端接受的是一个对象： id,name,age
    @GetMapping("/t2")
    public String test2(User user) {

        System.out.println(user);
        // 1.接收前端用户传递的参数，判断参数的名字，假设名字直接在方法上，可以直接使用
        // 2.假设传递的是一个对象User，匹配User对象中的字段名，如果名字一致则OK，否则就是null。

        // 表单提交 http://localhost:8080/springMVC_04_controllerconfig_war_exploded/user/t2?id=1&name=qinjiang&age=3
        return "hello";
    }


    @GetMapping("/t3")
    public String test3(ModelMap modelMap){

        return "hello";
    }
}
