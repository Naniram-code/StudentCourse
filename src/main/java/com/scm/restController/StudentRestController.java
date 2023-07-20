package com.scm.restController;

import com.scm.service.StudentServiceImpl;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.scm.model.Student;
import com.scm.service.StudentService;

import javax.validation.Valid;
import java.util.List;

@RestController

@RequestMapping("api/student")
public class StudentRestController {
    @Autowired

    private StudentServiceImpl service;


    // build create User REST API
    @PostMapping("/save")
    public ResponseEntity<Student> createUser(@Valid @RequestBody Student student){
        Student savedStudent = service.createStudent(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    // build get user by id REST API
    // http://localhost:8080/api/users/1
    @GetMapping("/{id}")
    public ResponseEntity<Student> getUserById(@PathVariable("id") Integer studentId){
        Student student = service.getUserById(studentId);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    // Build Get All Users REST API
    // http://localhost:8080/api/users
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student>student = service.getAllStudnet();
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    // Build Update User REST API
    @PutMapping("/update/{id}")
    // http://localhost:8080/api/student/update/1
    public ResponseEntity<Student> updateUser(@PathVariable("id") Integer studentId,
                                           @RequestBody Student student){
        student.setSid(studentId);
        Student updatedStudent = service.updateStudent(student);
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }

    // Build Delete User REST API
    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Integer studentId){
        service.deleteStudent(studentId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }
}
