<%--
  Created by IntelliJ IDEA.
  User: 10029
  Date: 2020/9/15
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js">
    </script>
    <%--<script src="${pageContext.request.contextPath}/statics/js/jquery-3.1.1.min.js"></script>--%>
    <script>
        function a1(){
            $.ajax({
                url:"${pageContext.request.contextPath}/a2",
                data:{'name':$("#txtName").val()},
                success:function (data,status) {
                    alert(data);
                    alert(status);
                }
            });
        }
    </script>
</head>
<body>

<%--onblur：失去焦点触发事件--%>
用户名:<input type="text" id="txtName" onblur="a1()"/>

</body>
</html>
