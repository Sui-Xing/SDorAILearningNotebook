package com.tf.controller;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//只要实现了Controller接口那么这个类就是一个控制器
//目的就是返回一个ModelAndView
public class controller_demo_test_01 implements Controller {
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","controller_demo_test_01");
        modelAndView.setViewName("test");

        return modelAndView;
    }

}
