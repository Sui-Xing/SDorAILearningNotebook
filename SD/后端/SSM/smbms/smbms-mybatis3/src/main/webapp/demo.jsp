<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: 10029
  Date: 2020/7/29
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <!-- import CSS -->
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>

</head>

<body>

<%
    //驱动程序名
    String driverName = "com.mysql.jdbc.Driver";
    //数据库用户名
    String userName = "root";
    //密码
    String userPasswd = "root";
    //数据库名
    String dbName = "7month_demo_db";
    //表名
    String tableName = "emp";
    //联结字符串
    String url = "jdbc:mysql://localhost:3306/" + dbName + "?user="
            + userName + "&password=" + userPasswd+" serverTimezone=UTC";
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    Connection connection = DriverManager.getConnection(url);
    Statement statement = connection.createStatement();
    String sql = "SELECT * FROM " + tableName;
    ResultSet rs = statement.executeQuery(sql);
%>


<div id="headline">
    <div id="zong">
        <div id="adtex" >
            管理员
        </div>
        <div id="adimg">
            <img src="管理员.png" height="20" width="20"/>
        </div>


    </div>


</div>
<div id="renyuanline">
    人员信息

</div>
<div id="biaoge">
<%--    <form action="test.java" method="post">--%>
        <div class="np">
            <b class="npw">姓名:</b><input name="username" class="iup" id="name" value="请选择">
        </div>
        <div class="np">
            <b class="npw">性别:</b><input name="sex" class="iup" id="sex" value="请选择">
        </div>
        <div class="np">
            <b class="npw">专业:</b><input name="sub" class="iup" id="sub" value="请输入">
        </div>
        <button class="npb" id="chaxun">
            查询
        </button>

        <button class="npb" id="chongzhi">
            重置
        </button>


<%--    </form>--%>

    <table id="customers" >
        <tr class="titlename">
            <th>序号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>出生年月</th>
            <th>毕业时间</th>
            <th>毕业院校</th>
            <th>专业</th>
            <th>任职公司</th>
            <th>职位</th>
            <th>操作</th>
        </tr>
            <%
                for(int i=0;i<15;i++){
            %>
                <%
                    if(rs.next()){
                %>
                    <tr class="datac tb" >
                        <%

                                for(int j=0;j<10;j++){
                        %>
                        <th>
                            <%
                                out.print(rs.getString(j+1));
                            %>
                        </th>
                        <%
                            }
                        %>
                    </tr>
                    <%
                        }
                    else {
                    %>
                    <tr id="datadb" class="tb">
                            <%

                                for(int j=0;j<10;j++){
                            %>
                            <th class="testth">


                            </th>
                            <%
                                }
                            %>
                    </tr>
                    <%
                        }

                    %>

            <%
                }
            %>

<%--        <tr id="line1">--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>


<%--        </tr>--%>
<%--        <tr id="line2" class="alt">--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--        </tr>--%>
<%--        <tr id="line3">--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--        </tr>--%>
<%--        <tr class="alt" id="line4">--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--        </tr>--%>
<%--        <tr class="alt" id="line5">--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--        </tr>--%>
<%--        <tr id="line6">--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--        </tr>--%>
<%--        <tr class="alt" id="line7">--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--        </tr>--%>
<%--        <tr id="line8">--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--        </tr>--%>
<%--        <tr class="alt" id="line9">--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--            <td></td>--%>
<%--        </tr>--%>
    </table>
    <ul class="pagination">
        <li><a href="#">«</a></li>
        <li><a class="active num" id="l1" href="#">1</a></li>
        <li><a class="nag num" href="#">2</a></li>
        <li><a class="nag num" href="#">3</a></li>
        <li><a class="nag num" href="#">4</a></li>
        <li><a class="nag num" href="#">5</a></li>
        <li><a class="nag num" href="#">6</a></li>
        <li><a class="nag num" href="#">7</a></li>
        <li><a  href="#">»</a></li>
    </ul>
</div>



</body>

<style>
    body {
        margin: 0;
        background-color: #dddddd;
    }
    * {
        box-sizing: border-box;
    }
    #headline{
        background-color: #127ac0;

        height:40px;

    }
    #zong{
        position: absolute;
        right: 30px;
    }
    #adimg{

        float:right;
        padding: 10px 10px;
    }
    #adtex{
        float:right;

        color: white;
        font-size: 1em;
        padding: 10px 0;

    }

    #renyuanline{
        background-color: white;
        font-size: 0.75em;
        padding-left: 10px;
        padding-top: 5px;
        padding-bottom: 5px;
    }
    #biaoge{
        background-color: white;
        margin:10px 10px;
        padding:20px 20px;

        overflow: auto;
        height: 100%;

    }
    .np{
        float: left;
        margin-right: 40px;
        font-size: 0.85em;


    }
    .iup{
        height: 30px;
        color: #cecece;
        padding-left: 10px;
        border: solid 1px #cecece;
        border-radius: 3px;
        font-size: 0.85em;
    }
    .npw{
        margin-right: 5px;
    }
    .npb{
        margin-right: 20px;
        height: 30px;
        width: 60px;
    }
    #chaxun{
        background-color: #35abfa;
        border-color: #357ebd;
        color: #fff;
        font-size: 0.70em;

        border-radius: 3px;
        border:transparent;



    }
    #chongzhi{
        border-color: #35abfa;
        background-color: white;
        color: #35abfa;
        font-size: 0.70em;
        border-style: solid;
        border-radius: 3px;
        border-width: 1px;

    }
    #customers
    {
        margin-top: 8px;

        width:100%;

        border-collapse:collapse;
    }
    #customers td, #customers th
    {
        height: 30px;
        font-size:0.70em;
        border:1px solid #cecece;
        padding:3px 7px 2px 7px;
    }
    #customers th
    {

        font-family: Monospace;
        font-style: normal;
        font-size:0.80em;
        text-align: center;
        padding-top:5px;
        padding-bottom:4px;
        background-color: #f2f2f2;

    }
   .titlename{
       color: #8c8c8c;
   }
    .datac{
        color: dimgrey;
    }
    #customers tr.alt td
    {
        color:#000000;
        background-color:#f2f2f2;
    }
    .pagination{
        float: right;
        margin-top: 20px;


    }
    ul.pagination {

        display: inline-block;

    }

    ul.pagination li {display: inline;}

    ul.pagination li a {
        color: black;
        float: left;
        padding: 8px 16px;
        text-decoration: none;
        transition: background-color .3s;
    }

    #l1 {
        background-color: #51a2d5;
        color: white;
    }

    /*ul.pagination li a:hover:not(.active) {background-color: #ddd;}*/
</style>
<script>
    $(function(){
        let flag=0;
        $(".num").mouseenter(
            function () {
                // alert("----------")
                flag=0;
                if($(this).attr("class")=="active num"){
                    //alert("===")
                }else{
                    // alert("==")
                    $(this).css({"background-color": "#ddd"})
                    $(this).click(没空搭理你这个虚嘎
                        function () {
                            if(flag==0){

                                //alert("前"+$(".active").text())
                                $(this).css({

                                    "background-color":" #51a2d5",
                                    "color": "white","text-decoration":"none",
                                    "transition": "background-color .3s"})
                                //$(".active").css("style","");
                                // alert("color:"+$(".active").css("background-color"))
                                //active变白
                                $(".active").css({
                                    "color":"black",
                                    "background-color":"white",
                                    "text-decoration":"none",
                                    "transition": "background-color .3s"
                                });
                                $(".active").attr("class", "nag num");
                                $(this).attr("class", "active num");
                                // alert("后"+$(".active").text())
                                flag=flag+1;
                            }

                            // return false;
                        }
                    )
                }

            }

        )
        $(".num").mouseleave(
            function () {
                if($(this).attr("class")=="active num"){

                }else{
                    $(this).css({
                        "color":"black",
                        "background-color":"white",
                        "text-decoration":"none",
                        "transition": "background-color .3s"
                    });
                }
            }

        )

            // alert(i)
            // alert($(".datac:eq(i)").css("background-color"));
            // $(".datac").indexOf(i).attr("background-color","");
        $("tr:odd>th").css("background-color","white")
        $(".iup").click(

            function () {
                $(this).val('');
            }
        )
        $("#chaxun").click(
            function () {
                $.post("test.java", {name:$(".iup").val()},
                    function(data,status){
                        alert("数据: \n" + data + "\n状态: " + status);
                    });
            }

        )

        // $(".num").each(
        //     function(){
        //         if($(this).attr("class")=="active num")
        //
        //         let flag=true;
        //         $(this).hover(
        //             function () {
        //                 $(this).css({"background-color": "#ddd"})
        //             },
        //             function () {
        //                 $(this).css({"background-color": "white","color":"black"})
        //             }
        //         )
        //     }
        //
        //
        //
        // )


        // $(".num").click(
        //     function () {
        //         $(this).unbind("hover");
        //         // $(".active").unbind("hover")
        //         $(this).removeAttr("style");
        //         alert($(this).text()+"  "+$(this).css("background-color"));
        //
        //         //this变蓝
        //         $(this).css({
        //             "background-color":" #51a2d5",
        //             "color": "white","text-decoration":"none",
        //             "transition": "background-color .3s"})
        //         //$(".active").css("style","");
        //
        //         //active变白
        //         $(".active").css({
        //                 "color":"black",
        //                 "background-color":"white",
        //                 "text-decoration":"none",
        //             "transition": "background-color .3s"
        //         });
        //         // $("a:honer.active").css(
        //         //     {
        //         //         "background-color": "#ddd"
        //         //     }
        //         // )
        //
        //
        //         // alert("wai2:"+$(".active").text())
        //
        //
        //
        //         $(".active").attr("class", "nag num");
        //         $(this).attr("class", "active num");
        //         // $(".nag").each(
        //         //     function () {
        //         //         alert("nag:"+$(this).text())
        //         //     }
        //         //
        //         //
        //         // )
        //         //alert("active:"+$(".nag").text())
        //
        //         let flag=true;
        //         $(".nag").each(
        //             function(){
        //                 $(this).hover(
        //                     function () {
        //                         $(this).css({"background-color": "#ddd"})
        //                     },
        //                     function () {
        //                         $(this).css({"background-color": "white","color":"black"})
        //                     })
        //             }
        //             )
        //         $(this).unbind("hover");
        //
        //     }
        //
        //
        //
        // )
        //
        // $(".nag").mouseup(
        //     function () {
        //         $(this).css({"background-color": "#ddd"})
        //     }
        // );



    });

</script>
</html>
