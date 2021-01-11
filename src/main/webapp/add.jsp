<%--
  Created by IntelliJ IDEA.
  User: cy
  Date: 2021/1/7
  Time: 11:20
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
        <form action="student/add" method="get">
            <table>
                <tr>
                    <td>姓名：</td>
                    <td><input type="text" name="name"></td>
                </tr>

                <tr>
                    <td>年龄：</td>
                    <td><input type="text" name="age"></td>
                </tr>

                <tr>
                    <td><input type="submit" value="提交"></td>
                    <td><input type="reset" value="清空"></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
