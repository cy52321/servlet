package com.a1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class QuestionAdd extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int result=0;
        String s1=req.getParameter("name");
        String s2=req.getParameter("optionA");
        String s3=req.getParameter("optionB");
        String s4=req.getParameter("optionC");
        String s5=req.getParameter("optionD");
        String s6=req.getParameter("answer");
        Question question=new Question(s1,s2,s3,s4,s5,s6);
        result=QuestionDao.add(question);
        if(result==1){
            req.setAttribute("key1","添加成功");
        }else {
            req.setAttribute("key1","添加失败");
        }
        req.getRequestDispatcher("/info.jsp").forward(req,resp);
    }
}
