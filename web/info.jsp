<%--
  Created by IntelliJ IDEA.
  User: cy
  Date: 2020/12/18
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String s=(String) request.getAttribute("key1");
%>
<html>
<body>
<center>
    <font style="color: red;font-size: 40px"><%=s%></font>
</center>
</body>

</html>
