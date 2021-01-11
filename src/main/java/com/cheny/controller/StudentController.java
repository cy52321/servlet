package com.cheny.controller;

import com.cheny.Service.StudentService;
import com.cheny.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService studentService;

    @RequestMapping("/add")
    public ModelAndView addStu( Student student){

        String tips="注册失败";
        ModelAndView mv=new ModelAndView();
        int num=studentService.add(student);
        if(num>0){
            tips="学生"+student.getName()+"注册成功";
        }
        mv.addObject("tips",tips);/*
        mv.addObject("id",student.getId());
        mv.addObject("name",student.getName());
        mv.addObject("age",student.getAge());*/
        mv.setViewName("result");/*
        mv.setViewName("forward:/WEB-INF/jsp/result.jsp");
        mv.setViewName("redirect:/hello.jsp");*/
        return mv;
    }
    @RequestMapping("/query")
    @ResponseBody
    public List<Student> query(/*HttpServletRequest request*/){/*
        System.out.println(request.getParameter("name"));*/
        return studentService.query();
    }
}
