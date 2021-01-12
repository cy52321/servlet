package com.a1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Userlogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username,password;
        int result=0;
        req.setCharacterEncoding("utf-8");
        username=req.getParameter("username");
        password=req.getParameter("password");
        result=UserDao.login(username,password);
        if(result==1){
            HttpSession session=req.getSession();
            resp.sendRedirect("/myWeb/index2.html");
        }else {
            resp.sendRedirect("/myWeb/login_error.html");
        }

    }
}
