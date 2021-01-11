package com.cheny.Service;

import com.cheny.domain.Student;

import java.util.List;

public interface StudentService {
    int add(Student student);
    List<Student> query();
}
