package com.tf.servlet;

import com.sun.org.apache.xerces.internal.impl.dv.xs.DateTimeDV;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;


public class cookie_servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        int k=0;
//        for (Cookie cookie : cookies) {
//            System.out.println(k++);
//            System.out.println(cookie);
//        }
        boolean flag=false;
        if(cookies!=null){
            System.out.println(cookies.length);
            for (int i=0;i<cookies.length;i++) {
               System.out.println("i="+i+"||"+cookies.length);
                if(cookies[i].getName().equals("LastLoginTime")){
                    SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                    String dateStr = dateformat.format(new Date(Long.parseLong(cookies[i].getValue())));
//                    System.out.println("--------------------");
                    resp.getWriter().print("上次登录的时间是：");
                    resp.getWriter().print(dateStr);
//                    System.out.println("==============");

                    flag=true;
                    break;
                }
                else {
                    flag=false;

                }
            }
        }

        if(!flag){
            resp.getWriter().print("这是tm的第一次登录，没有上次登录的时间");
        }


//        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Cookie cookie = new Cookie("LastLoginTime",System.currentTimeMillis()+"");
//        System.out.println(date);
        resp.addCookie(cookie);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

}
