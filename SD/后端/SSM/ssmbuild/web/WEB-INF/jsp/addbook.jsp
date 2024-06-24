<%--
  Created by IntelliJ IDEA.
  User: 10029
  Date: 2020/9/12
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/book/addBook" method="post" >


    书籍名：<input type="text" name="bookName" ><br><br><br>
    书籍数量：<input type="text" name="bookCounts" ><br><br><br>
    书籍描述：<input type="text" name="detail" ><br><br><br>
    <input type="submit" value="添加">

</form>
</body>
</html>
