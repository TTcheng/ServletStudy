<%--
  Created by IntelliJ IDEA.
  User: WangChunCheng
  Date: 2018/3/23
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功页面</title>
    <style type="text/css">
    body{
        color:#000;
        font-size:14px;
        margin: 20px auto;
    }
    #message{
        text-align: center;
    }
</style>
</head>
<body>
<div id="message">
    登录成功！<br>
    您提交的信息为:<br>
    用户名：<%=request.getParameter("uname")%><br>
    密码：<%=request.getParameter("upwd")%><br>
    <a href="login.jsp">返回登录页面</a>
</div>
</body>
</html>
