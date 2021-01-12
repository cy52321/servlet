package com.a1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionFindid extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("questionID"));
        Question qu=QuestionDao.findid(String.valueOf(req.getParameter("questionID")));
        req.setAttribute("key3",qu);
        req.getRequestDispatcher("/index4.jsp").forward(req,resp);
    }
}
