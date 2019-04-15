package com.learningstuff.springbootrestswaggerdemo.repository;


import com.learningstuff.springbootrestswaggerdemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {


    List<Student> findStudentsByStudentNameContains(String name);

}
