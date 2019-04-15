package com.learningstuff.springbootrestswaggerdemo.controller;


import com.learningstuff.springbootrestswaggerdemo.model.Student;
import com.learningstuff.springbootrestswaggerdemo.repository.StudentRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(value = "student")
@Api(value = "Student Resource", description = "Show all RESTfull API")
public class StudentController {

    private final StudentRepository studentRepository;


    @GetMapping(value = "all")
    public List<Student> getAllStudent() {

        return studentRepository.findAll();
    }


    @ApiOperation(value = "Returns All Student By Name Or All")
    @ApiResponses(
            value = {
                    @ApiResponse(code=100, message = "100 is the message,(if custom message and code needed)"),  // If custom message and code needed
                    @ApiResponse(code = 200, message = "Successfully get student")
            }
    )
    @GetMapping
    public ResponseEntity<?> getAllStudent(@RequestParam(value = "name", defaultValue = "", required = false) String name) {

        return ResponseEntity.ok(studentRepository.findStudentsByStudentNameContains(name));
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<?> getStudent(@PathVariable(value = "id") String id) {

        Optional<Student> student = studentRepository.findById(id);

        return student.isPresent() ? ResponseEntity.ok(student) : ResponseEntity.badRequest().body("Student not present for id = " + id);
    }

    @PostMapping
    public Student saveStudent(@RequestBody Student student) {

        Student saveStudent = studentRepository.save(student);

        return saveStudent;
    }


    @PutMapping(value = "{id}")
    public ResponseEntity<?> updateStudent(@RequestBody Student student, @PathVariable(value = "id") String id) {

//        if (!studentRepository.findById(id).isPresent()) {
//            return ResponseEntity.badRequest().body("Student not present for id = " + id);
//        }
//
        if (student.getStudentId().equals(id)) {

            Student updateStudent = studentRepository.save(student);

            return ResponseEntity.ok(updateStudent);
        }


        return ResponseEntity.badRequest().body("Mismatch Id!");
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> updateStudent(@PathVariable(value = "id") String id) {

        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (!optionalStudent.isPresent()) {
            return ResponseEntity.badRequest().body("Student not present for id = " + id);
        }

        optionalStudent.ifPresent(studentRepository::delete);

        return ResponseEntity.ok().body("Successfully deleted!");
    }


}
