package com.tf.filter;


import com.tf.pojo.User;
import com.tf.util.Constant;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//跳转首页过滤器
public class SysFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest)request ;
        HttpServletResponse resp=(HttpServletResponse) response ;
        HttpSession session = req.getSession();
        User attribute = (User) session.getAttribute(Constant.USER_SESSION);
        if(attribute!=null){
            chain.doFilter(request, response);
        }else {
            resp.sendRedirect(req.getContextPath()+"/login.jsp");
        }

    }

    @Override
    public void destroy() {

    }
}
