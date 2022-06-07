<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: 10029
  Date: 2020/8/10
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
    姓名
    <%
        System.out.println(request.getParameter("name"));
        String name = URLDecoder.decode(request.getParameter("name"), "UTF-8");
        System.out.println(name);
        out.print(name);
    %>
    年龄
    <%
        out.print(request.getParameter("age"));
    %>
</body>
</html>
