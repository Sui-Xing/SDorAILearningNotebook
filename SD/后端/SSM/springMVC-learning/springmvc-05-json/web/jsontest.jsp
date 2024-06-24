<%--
  Created by IntelliJ IDEA.
  User: 10029
  Date: 2020/9/6
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Title</title>

    <%--script不能单闭合--%>
    <script type="text/javascript">

        var user={
            name:"name",
            age:3,
            sex:"男"
        };


        // 将js对象转换成json对象
        var json=JSON.stringify(user);

        console.log(json);


        console.log("===============");
        // 将json对象转换成js对象
        var obj=JSON.parse(json)

        console.log(obj);
    </script>
</head>
<body>

</body>
</html>
