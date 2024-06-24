package com.tf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//@Controller
//public class RestFulController {
//    @RequestMapping("/add/{a}/{b}")
//    public String test1(@PathVariable int a, @PathVariable int b, Model model){
//        int res=a+b;
//        model.addAttribute("msg","结果为"+res);
//        return "hello";
//    }
//}
@Controller
public class RestFulController {
    // 原来的的：localhost:8080/add?a=1&b=2
    // RestFull:localhost:8080/add/a/b

    // @RequestMapping("/add/{a}/{b}")
    // @RequestMapping(value = "/add/{a}/{b}",method = RequestMethod.GET)
    // @GetMapping("/add/{a}/{b}")
    @PostMapping("/add/{a}/{b}")
    public String test1(@PathVariable int a, @PathVariable int b, Model model){
        int res=a+b;
        System.out.println("start");
        model.addAttribute("msg","结果为"+res);
        return "hello";
    }


}
