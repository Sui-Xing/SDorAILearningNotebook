package com.tf.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class request_login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("utf-8");
        System.out.println("后台启动");
        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");
        String[] hobbies = req.getParameterValues("hobbies");
        System.out.println("=============================");
        System.out.println(req.getContextPath());
        System.out.println("=============================");
        System.out.println(username);
        System.out.println(pwd);
        for (String hobby : hobbies) {
            System.out.print(hobby);

        }
        System.out.println();

        System.out.println("=============================");
//      resp.sendRedirect("/login_success_02.jsp");
        req.getRequestDispatcher("/login_success_02.jsp").forward(req,resp);

//        resp.getWriter().print(username+"=="+pwd);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
