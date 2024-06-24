<%@ page import="org.omg.IOP.Encoding" %>
<%@ page import="java.net.URLEncoder" %><%--
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

    <jsp:forward page="/req02.jsp">
        <%="aa"%>
        <%
        String xiaohong = URLEncoder.encode("小红", "UTF-8");
        %>
        <jsp:param name="name" value=xiaohong/>
        <jsp:param name="age" value="13"/>
    </jsp:forward>
    <%
        String str="aa";
        request.setCharacterEncoding("UTF-8");
    %>
</body>
</html>
