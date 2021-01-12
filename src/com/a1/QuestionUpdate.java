package com.a1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer i1=Integer.valueOf(req.getParameter("questionID"));
        int result=0;
        String s1=req.getParameter("name");
        String s2=req.getParameter("optionA");
        String s3=req.getParameter("optionB");
        String s4=req.getParameter("optionC");
        String s5=req.getParameter("optionD");
        String s6=req.getParameter("answer");
        Question question=new Question(i1,s1,s2,s3,s4,s5,s6);
        result=QuestionDao.update(question);
        if(result==1){
            req.setAttribute("key1","更新成功");
        }else {
            req.setAttribute("key1","更新失败");
        }
        req.getRequestDispatcher("/info.jsp").forward(req,resp);
    }
}
