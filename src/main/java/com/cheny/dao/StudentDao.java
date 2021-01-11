package com.cheny.dao;

import com.cheny.domain.Student;

import java.util.List;

public interface StudentDao {
    int insert(Student student);
    List<Student> select();
}
