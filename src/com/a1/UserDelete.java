package com.a1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s;
        PrintWriter pw=null;
        int result=0;
        s=req.getParameter("userId");
        result=UserDao.delete(s);
        resp.setContentType("text/html;charset=utf-8");
        pw=resp.getWriter();
        if(result==1){
            pw.print("<font style='color:red;font-size:40px'>删除成功</font>");
        }else {
            pw.print("<font style='color:red;font-size:40px'>删除失败</font>");
        }
    }
}
