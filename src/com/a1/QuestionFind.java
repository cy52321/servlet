package com.a1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuestionFind extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Question> li=new ArrayList<>();
        li=QuestionDao.find();
        req.setAttribute("key2",li);
        req.getRequestDispatcher("/index3.jsp").forward(req,resp);
    }
}
