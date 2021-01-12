package com.a1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class QuestionTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Question> list=QuestionDao.test();
        HttpSession session=req.getSession(false);
        session.setAttribute("test",list);
        req.getRequestDispatcher("/index5.jsp").forward(req,resp);
    }
}
