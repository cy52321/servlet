<%@ page import="com.a1.Question" %><%--
  Created by IntelliJ IDEA.
  User: cy
  Date: 2020/12/18
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Question q=(Question) request.getAttribute("key3");
%>
<center>
    <form action="/myWeb/questionupdate" method="get">
        <table border="2">
            <tr align="center">
                <td>题号：</td>
                <td><input type="text" name="questionID" value="<%=q.getQuestionID()%>" readonly></td><%--readonly--%>
            </tr>
            <tr align="center">
                <td>题目：</td>
                <td><input type="text" name="name" value="<%=q.getTitle()%>"></td>
            </tr>
            <tr align="center">
                <td>A：</td>
                <td><input type="text" name="optionA"value="<%=q.getOptionA()%>"></td>
            </tr>
            <tr align="center">
                <td>B：</td>
                <td><input type="text" name="optionB" value="<%=q.getOptionB()%>"></td>
            </tr>
            <tr align="center">
                <td>C：</td>
                <td><input type="text" name="optionC" value="<%=q.getOptionC()%>"></td>
            </tr>
            <tr align="center">
                <td>D：</td>
                <td><input type="text" name="optionD" value="<%=q.getOptionD()%>"></td>
            </tr>
            <tr>
                <td>正确答案：</td>
                <td>
                    <input type="radio" name="answer" value="A" <%="A".equals(q.getAnswer())?"checked":""%>>A
                    <input type="radio" name="answer" value="B" <%="B".equals(q.getAnswer())?"checked":""%>>B
                    <input type="radio" name="answer" value="C" <%="C".equals(q.getAnswer())?"checked":""%>>C
                    <input type="radio" name="answer" value="D" <%="D".equals(q.getAnswer())?"checked":""%>>D
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="更新试题"></td>
                <td align="center"><input type="reset" value="清空"></td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
