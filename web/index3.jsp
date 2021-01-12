<%@ page import="java.util.List" %>
<%@ page import="com.a1.Question" %><%--
  Created by IntelliJ IDEA.
  User: cy
  Date: 2020/12/18
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<Question> list= (List<Question>) request.getAttribute("key2");
%>
<table border="2px" align="center">
    <tr>
        <td>题号</td>
        <td>题目</td>
        <td>A</td>
        <td>B</td>
        <td>C</td>
        <td>D</td>
        <td>答案</td>
    </tr>

<%
    for(Question q:list){
%>
    <tr>
        <td><%=q.getQuestionID()%></td>
        <td><%=q.getTitle()%></td>
        <td><%=q.getOptionA()%></td>
        <td><%=q.getOptionB()%></td>
        <td><%=q.getOptionC()%></td>
        <td><%=q.getOptionD()%></td>
        <td><%=q.getAnswer()%></td>
        <td><a href="/myWeb/questiondelete?questionID=<%=q.getQuestionID()%>">删除试题</a></td>
        <td><a href="/myWeb/questionfindid?questionID=<%=q.getQuestionID()%>">详细信息</a></td>
    </tr>
<%
    }
%>

</table>
</body>
</html>
