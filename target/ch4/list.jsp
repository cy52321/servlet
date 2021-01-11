<%--
  Created by IntelliJ IDEA.
  User: cy
  Date: 2021/1/7
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basepath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>
<head>
    <title>Title</title>
    <base href="<%=basepath%>">
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(function () {
            $.ajax({
                url:"student/query",
                type:"get",
                data:{"name":"sds"},
                dataType:"json",
                success:function (resp) {
                    $("#tab").empty();
                    $.each(resp,function (i,n) {
                        $("#tab").append("<tr>").
                        append("<td>"+n.id+"</td>").
                        append("<td>"+n.name+"</td>").
                        append("<td>"+n.age+"</td>").
                        append("</tr>")
                    })
                }
            })
            $("#btn").click(function () {
                $.ajax({
                    url:"student/query",
                    type:"get",
                    dataType:"json",
                    success:function (resp) {
                        $("#tab").empty();
                        $.each(resp,function (i,n) {
                            $("#tab").append("<tr>").
                                append("<td>"+n.id+"</td>").
                                append("<td>"+n.name+"</td>").
                                append("<td>"+n.age+"</td>").
                                append("</tr>")
                        })
                    }
                })
            })
        })
    </script>
</head>
<body>
    <div align="center">
        <table>
            <thead>
            <tr>
                <td>学号</td>
                <td>姓名</td>
                <td>年龄</td>
            </tr>
            </thead>
            <tbody id="tab">

            </tbody>
        </table>
        <input type="button" id="btn" value="查询数据">
    </div>
</body>
</html>
