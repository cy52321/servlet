package com.a1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class QuestionCheck extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession(false);
        List<Question> list= (List<Question>) session.getAttribute("test");
        int score=0;
        for (Question question:list){
            String answer=question.getAnswer();
            String useranswer=req.getParameter("answer_"+question.getQuestionID());
            if(useranswer.equals(answer)){
                score+=25;
            }
        }
        req.setAttribute("key1",("得分为： "+String.valueOf(score)+"分"));
        req.getRequestDispatcher("/info.jsp").forward(req,resp);
    }
}
