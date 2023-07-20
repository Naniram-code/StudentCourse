package com.scm.service;



import java.util.List;

import com.scm.model.Student;

public interface StudentService {
    Student createStudent(Student student);

    Student getUserById(Integer studentId);

    List<Student> getAllStudnet();

    Student updateStudent(Student student);

    void deleteStudent(Integer studentId);
}
