<%--
  Created by IntelliJ IDEA.
  User: 10029
  Date: 2020/9/15
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>



    <script>
        // 失去焦点的操作
        $(function () {
            $("#input1").blur(function () {
                <%--alert("${pageContext.request.contextPath}/a1");--%>
                $.ajax({
                   url: "${pageContext.request.contextPath}/a1",
                    success:function (data) {
                        console.log(data)
                        var html="";
                        for (var i = 0; i <data.length ; i++) {
                            html+= "<tr>" +
                                "<td>" + data[i].id + "</td>" +
                                "<td>" + data[i].name + "</td>" +
                                "<td>" + data[i].age + "</td>" +
                                "</tr>"
                        }

                        $("#tbody").html(html);
                    }
                });
            })
        })

        // ============================================
        // 一定要注意jQuery选择器是$(),是小括号而不是大括号
        // ============================================
        // 点击按钮的操作
        $(function () {
            $("#bt1").click(function () {
                $.ajax({
                    url:"${pageContext.request.contextPath}/a1",
                    // data:{'name':$("#txtName").val()},
                    success:function (data) {
                        console.log(data)
                        var html="";
                        for (var i = 0; i <data.length ; i++) {

                            html+="<tr>"+
                                "<td>"+data[i].id+"</td>"+
                                "<td>"+data[i].name+"</td>"+
                                "<td>"+data[i].age+"</td>"+
                                "</tr>";
                        }
                        $("#tbody").html(html);
                        alert(data)
                    }
                });

            })

            <%--$("#input1").click(function () {--%>
            <%--    $.ajax({--%>
            <%--        url:"${pageContext.request.contextPath}/a1",--%>
            <%--        // data:{'name':$("#txtName").val()},--%>
            <%--        success:function (data) {--%>
            <%--            console.log(data)--%>
            <%--            var html="";--%>
            <%--            for (var i = 0; i <data.length ; i++) {--%>

            <%--                html+="<tr>"+--%>
            <%--                    "<td>"+data[i].id+"<td>"+--%>
            <%--                    "<td>"+data[i].name+"<td>"+--%>
            <%--                    "<td>"+data[i].age+"<td>"+--%>
            <%--                    "<tr>";--%>
            <%--            }--%>
            <%--            ${"#tbody"}.html(html);--%>
            <%--            alert(data)--%>
            <%--        }--%>
            <%--    });--%>

            <%--})--%>

        })




        function f2() {
            alert("f2")
        }

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
    <%--<script>--%>
    <%--    function a1(){--%>
    <%--        $.ajax({--%>
    <%--            url:"${pageContext.request.contextPath}/a2",--%>
    <%--            data:{'name':$("#txtName").val()},--%>
    <%--            success:function (data,status) {--%>
    <%--                alert(data);--%>
    <%--                alert(status);--%>
    <%--            }--%>
    <%--        });--%>
    <%--    }--%>
    <%--</script>--%>
</head>
<body>

    <input type="text" name="username" id="input1">
    <input type="button" id="bt1" value="获取"><br>
用户名:<input type="text" id="txtName" onblur="a1()"/>



<table>
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>

    </tr>
    <tbody id="tbody">

    </tbody>
</table>

</body>
</html>
