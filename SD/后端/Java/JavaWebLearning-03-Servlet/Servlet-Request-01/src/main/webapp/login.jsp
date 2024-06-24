<%--
  Created by IntelliJ IDEA.
  User: 10029
  Date: 2020/8/5
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <form method="post" style="text-align: center" name="login" action="${pageContext.request.contextPath}/loginserv">

        用户名：<input name="username" value="请输入用户名"><br>
        密码：<input name="pwd" value="请输入密码" type="password"><br>
        爱好：<input name="hobbies" type="checkbox" value="女孩">女孩
        <input name="hobbies" type="checkbox" value="代码">代码
        <input name="hobbies" type="checkbox" value="wows">WOWS
        <br>
        <input type="submit">
    </form>

</body>
</html>
