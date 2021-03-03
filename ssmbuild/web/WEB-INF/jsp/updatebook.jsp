<%--
  Created by IntelliJ IDEA.
  User: 10029
  Date: 2020/9/13
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


    <form action="${pageContext.request.contextPath}/book/updateBook" method="post" >

        <input type="hidden" name="bookID" value=${book.bookID}>
        书籍名：<input type="text" name="bookName" value=${book.bookName}><br><br><br>
        书籍数量：<input type="text" name="bookCounts" value=${book.bookCounts} ><br><br><br>
        书籍描述：<input type="text" name="detail" value=${book.detail}><br><br><br>
        <input type="submit" value="修改">

    </form>
</body>
</html>
