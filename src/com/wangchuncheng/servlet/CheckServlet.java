package com.wangchuncheng.servlet;

import com.wangchuncheng.entity.User;
import com.wangchuncheng.service.CheckUserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CheckServlet extends HttpServlet {
    public CheckServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname=req.getParameter("uname");
        String pwd=req.getParameter("upwd");
        CheckUserService checkUserService = new CheckUserService();
        String forward = null;
        RequestDispatcher requestDispatcher = null;
        if (uname==null||pwd==null){
            req.setAttribute("msg","用户名或者密码为空");
            forward = "/error.jsp";
        }else {
            User user = new User();
            user.setName(uname);
            user.setPassword(pwd);
            boolean bool = checkUserService.check(user);
            if (bool) {
                forward = "/success.jsp";
            }else {
                req.setAttribute("msg","用户名或者密码输入错误，请重新输入");
                forward = "/error.jsp";
            }
        }
        requestDispatcher = req.getRequestDispatcher(forward);
        requestDispatcher.forward(req,resp);
    }
}
