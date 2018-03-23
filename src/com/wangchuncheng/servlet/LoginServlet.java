package com.wangchuncheng.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 打印客户端输入的登录信息
 * http://localhost:8080/LoginServlet/login.jsp
 */
public class LoginServlet extends HttpServlet {
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        String userName = req.getParameter("uname");
//        String password = req.getParameter("upwd");
//        System.out.println("用户名==》"+userName);
//        System.out.println("密码==》"+password);
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("===========进入doGet===========");
        doPost(req,resp);
//        String userName = req.getParameter("uname");
//        String password = req.getParameter("upwd");
//        System.out.println("用户名==》"+userName);
//        System.out.println("密码==》"+password);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("===========进入doPost===========");
        String userName = req.getParameter("uname");
        String password = req.getParameter("upwd");
        System.out.println("用户名==》"+userName);
        System.out.println("密码==》"+password);

        String forward = null;
        if (userName.equals("Jesse")&&password.equals("123456")){
            //请求转发  请求转发不能转发给其他应用
            forward = "/success.jsp";
            RequestDispatcher requestDispatcher = req.getRequestDispatcher(forward);
            requestDispatcher.forward(req,resp);
            //请求重定向
            //resp.sendRedirect(req.getContextPath()+"success.jsp");
        }else {
            //请求转发
            forward = "/error.jsp";
            RequestDispatcher requestDispatcher = req.getRequestDispatcher(forward);
            requestDispatcher.forward(req,resp);
            //请求重定向
            //resp.sendRedirect(req.getContextPath()+"error.jsp");
        }
    }
}
