package com.tf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.tf.pojo.*;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AjaxController {
    @RequestMapping("/a1")
    public List<User> getList(){

        List<User> list = new ArrayList<User>();

        list.add(new User(1,"小王",3));
        list.add(new User(2,"小刚",3));
        list.add(new User(3,"小赵",3));

        return list;
    }


    @RequestMapping("/a2")
    public void ajax1(String name , HttpServletResponse response) throws IOException {
        if ("admin".equals(name)){
            response.getWriter().print("true");
        }else{
            response.getWriter().print("false");
        }
    }


}
