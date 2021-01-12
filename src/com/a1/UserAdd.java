package com.a1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class UserAdd extends HttpServlet {
    /*protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username,password,sex,email;
        int result=0;
        User user=null;
        PrintWriter pw=null;
        req.setCharacterEncoding("utf-8");
        username=req.getParameter("username");
        password=req.getParameter("password");
        sex=req.getParameter("sex");
        email=req.getParameter("email");
        user=new User(username,password,sex,email);
        result=UserDao.add(user);
        resp.setContentType("text/html;charset=utf-8");
        pw=resp.getWriter();
        if(result==1){
            pw.println("<font style='color:red;font-size:40px'>注册成功</font>");
        }else {
            pw.println("<font style='color:red;font-size:40px'>注册失败</font>");
        }
    }
*/
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username,password,sex,email;
        int result=0;
        User user=null;
        PrintWriter pw=null;
        username=req.getParameter("username");
        password=req.getParameter("password");
        sex=req.getParameter("sex");
        email=req.getParameter("email");
        user=new User(username,password,sex,email);
        Date start=new Date();
        result=UserDao.add(user,req);
        Date end=new Date();
        System.out.println("花费时间为："+(end.getTime()-start.getTime())+"毫秒");
        resp.setContentType("text/html;charset=utf-8");
        pw=resp.getWriter();
        if(result==1){
            pw.println("<font style='color:red;font-size:40px'>注册成功</font>");
        }else {
            pw.println("<font style='color:red;font-size:40px'>注册失败</font>");
        }
    }
}
