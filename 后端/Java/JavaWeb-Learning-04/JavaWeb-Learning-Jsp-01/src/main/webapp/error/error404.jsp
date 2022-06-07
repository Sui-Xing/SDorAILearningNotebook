<%--
  Created by IntelliJ IDEA.
  User: 10029
  Date: 2020/8/10
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--图像路径--%>
<h1>${pageContext.request.contextPath}/img/404.jpg</h1>
<h1><%=request.getContextPath()%>/img/404.jpg</h1>
<h1><%request.getContextPath();%></h1>

    <img src="${pageContext.request.contextPath}/img/404.jpg">
    <img src="<%=request.getContextPath()%>/img/404.jpg">

</body>
</html>
