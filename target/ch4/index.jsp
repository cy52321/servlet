<%--
  Created by IntelliJ IDEA.
  User: cy
  Date: 2021/1/7
  Time: 10:14
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
</head>
<body>
    <div align="center">
        <img src="images/p1.png">
        <table>
            <tr>
                <td><a href="add.jsp">添加学生</a> </td>
            </tr>
            <tr>
                <td><a href="list.jsp">查询学生</a> </td>
            </tr>
        </table>
    </div>
</body>
</html>
