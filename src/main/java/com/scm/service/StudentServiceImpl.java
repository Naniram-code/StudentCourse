package com.scm.service;

import lombok.AllArgsConstructor;


import org.apache.logging.log4j.util.Strings;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.scm.model.Student;
import com.scm.repo.StudentRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service

public class StudentServiceImpl implements StudentService {
@Autowired
    private StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {

        return studentRepository.save(student);
    }

    @Override
    public Student getUserById(Integer studentId) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        return optionalStudent.get();
    }

    @Override
   public List<Student> getAllStudnet() {

        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(@NotNull Student student) {
    	
        Student existingStudent = studentRepository.findById(student.getSid()).get();
        existingStudent.setSname(student.getSname());
        existingStudent.setSadd(student.getSadd());
        existingStudent.setEmail(student.getEmail());
        
        Student updatedStudent = studentRepository.save(existingStudent);
        return updatedStudent;
    }

    @Override
    public void deleteStudent(Integer studentId) {

        studentRepository.deleteById(studentId);
    }
}
