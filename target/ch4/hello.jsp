<%--
  Created by IntelliJ IDEA.
  User: cy
  Date: 2021/1/7
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${param.name}<br>
${param.id}<br>
<%=request.getParameter("age")%>
</body>
</html>
