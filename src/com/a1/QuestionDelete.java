package com.a1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s=req.getParameter("questionID");
        int result=QuestionDao.delete(s);
        if(result==1){
            req.setAttribute("key1","删除成功");
        }else {
            req.setAttribute("key1","删除失败");
        }
        req.getRequestDispatcher("/info.jsp").forward(req,resp);
    }
}
