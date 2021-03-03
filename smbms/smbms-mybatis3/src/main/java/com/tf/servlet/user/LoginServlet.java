package com.tf.servlet.user;

import com.tf.pojo.User;
import com.tf.service.User.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.tf.util.Constant.USER_SESSION;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");
        try {

            UserServiceImpl userService=new UserServiceImpl();
            User user = userService.login(userName,userPassword);
            System.out.println(user);
            if(user!=null){

                req.getSession().setAttribute(USER_SESSION,user);
//                遗留路径问题
                resp.sendRedirect(req.getContextPath()+"/jsp/frame.jsp");
            }else{
                req.setAttribute("error","用户名或者密码不正确");
                req.getRequestDispatcher("login.jsp").forward(req,resp);
            }
        } catch (Exception e) {
            e.printStackTrace();

            req.setAttribute("error","用户名或者密码不正确");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
