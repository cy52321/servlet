package com.a1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UserFind extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*HttpSession session=req.getSession(false);
        if(session==null){
            resp.sendRedirect("/myWeb/login_error.html");
            return;
        }*/
        List<User> userlist=UserDao.findall();
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw=resp.getWriter();
        pw.print("<table border='2' aligen='center'>");
        pw.print("<tr>");
        pw.print("<td>用户编号</td>");
        pw.print("<td>用户姓名</td>");
        pw.print("<td>用户密码</td>");
        pw.print("<td>用户性别</td>");
        pw.print("<td>用户邮箱</td>");
        pw.print("</tr>");
        for(User us:userlist){
            pw.print("<tr>");
            pw.print("<td>"+us.getUserid()+"</td>");
            pw.print("<td>"+us.getUsername()+"</td>");
            pw.print("<td>"+"******"+"</td>");
            pw.print("<td>"+us.getSex()+"</td>");
            pw.print("<td>"+us.getEmail()+"</td>");
            pw.print("<td><a href='delete?userId="+us.getUserid()+"'>删除用户</a></td>");
            pw.print("</tr>");
        }
        pw.print("</table>");
    }
}
