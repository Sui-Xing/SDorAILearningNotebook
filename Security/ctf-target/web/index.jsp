<%--
  Created by IntelliJ IDEA.
  User: 10029
  Date: 2020/9/29
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form method="post" action="${pageContext.request.contextPath}/t">
    username:<input type="text" name="username" >
    <input type="submit">
  </form>
  <?php
    echo "Hello World!";
   ?>
  <label>
    <script type="text/javascript">
      document.write("${username1}")

    </script>
    "==="
  </label>

  </body>
</html>
