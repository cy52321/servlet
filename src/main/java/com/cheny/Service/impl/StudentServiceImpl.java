package com.cheny.Service.impl;

import com.cheny.Service.StudentService;
import com.cheny.dao.StudentDao;
import com.cheny.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;

    public StudentServiceImpl() {
    }

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    @Transactional
    public int add(Student student) {
        int nums=studentDao.insert(student);
        return nums;
    }

    @Override
    @Transactional
    public List<Student> query() {
        List<Student> list=studentDao.select();
        return list;
    }
}
