package com.learningstuff.springbootrestswaggerdemo;

import com.learningstuff.springbootrestswaggerdemo.model.Student;
import com.learningstuff.springbootrestswaggerdemo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringBootRestSwaggerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestSwaggerDemoApplication.class, args);
    }


    @Bean
    CommandLineRunner runner(StudentRepository studentRepository) {
        return args -> {

            List<Student> students = new ArrayList<>(Arrays.asList(
                    new Student("1", "Student1", "Male", 3.6),
                    new Student("2", "Student2", "Female", 3.5),
                    new Student("3", "Student3", "Female", 3.1),
                    new Student("4", "Student4", "Male", 3.3),
                    new Student("5", "Student5", "Male", 3.9)
            ));

            studentRepository.saveAll(students).forEach(System.out::println);

        };
    }


}
