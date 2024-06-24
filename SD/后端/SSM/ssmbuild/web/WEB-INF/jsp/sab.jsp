<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="display" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 10029
  Date: 2020/9/9
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<html>
<head>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <title>书籍展示</title>
</head>
<body>
    <div class="container">
        <div class="row clearfix">
            <div class="page-header">
                <h1>
                    <small>书籍列表--展示所有书籍</small>
                </h1>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4 column">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/toAddBook">新增</a>
            </div>
            <div class="col-md-4 column"></div>
            <div class="col-md-4 column">
                <form  class="form-inline" action="${pageContext.request.contextPath}/book/queryBookByName" method="post">
                    <span  style="font-size: larger"  class="label label-danger">${error}</span>
                    <input class="form-control"   type="text" name="bookname" placeholder="输入书籍名称">
                    <input type="submit" class="btn btn-primary" value="查询">
                </form>
            </div>
        </div>

    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <table class="table table-hover table-striped">
                    <thead>
                        <tr>
                            <th>书籍编号</th>
                            <th>书籍名称</th>
                            <th>书籍数量</th>
                            <th>书籍描述</th>
                            <th>操作</th>

                        </tr>

                    </thead>
                    <tbody>
                        <c:forEach var="bks" items="${books}">
                            <tr>
                                <th>${bks.bookID}</th>
                                <th>${bks.bookName}</th>
                                <th>${bks.bookCounts}</th>
                                <th>${bks.detail}</th>
                                <th>
                                    <a href="${pageContext.request.contextPath}/book/toUpdateBook/${bks.bookID}">修改</a>
                                    |
                                    <a href="${pageContext.request.contextPath}/book/deleteBook/${bks.bookID}">删除</a>

                                </th>
                            </tr>
                        </c:forEach>

                    </tbody>
                </table>

            </div>


        </div>



    </div>
    </div>
</body>
</html>
