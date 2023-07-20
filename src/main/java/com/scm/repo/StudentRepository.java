package com.scm.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.scm.model.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    //Student findByCourse_ID(Integer course_ID);
}
