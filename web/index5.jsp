<%@ page import="java.util.List" %>
<%@ page import="com.a1.Question" %><%--
  Created by IntelliJ IDEA.
  User: cy
  Date: 2020/12/19
  Time: 9:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <form action="/myWeb/check" method="get">
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
            List<Question> que= (List<Question>) session.getAttribute("test");
            for(Question q:que){
        %>
        <tr>
            <td><%=q.getQuestionID()%></td>
            <td><%=q.getTitle()%></td>
            <td><%=q.getOptionA()%></td>
            <td><%=q.getOptionB()%></td>
            <td><%=q.getOptionC()%></td>
            <td><%=q.getOptionD()%></td>
            <td>
                <input type="radio" name="answer_<%=q.getQuestionID()%>" value="A" >A
                <input type="radio" name="answer_<%=q.getQuestionID()%>" value="B" >B
                <input type="radio" name="answer_<%=q.getQuestionID()%>" value="C" >C
                <input type="radio" name="answer_<%=q.getQuestionID()%>" value="D" >D
            </td>
        </tr>
        <%
            }
        %>
        <tr align="center">
            <td colspan="3"><input type="submit" value="提交"></td>
            <td colspan="4"><input type="reset" value="清空"></td>
        </tr>

    </table>
    </form>
</center>
</body>
</html>
