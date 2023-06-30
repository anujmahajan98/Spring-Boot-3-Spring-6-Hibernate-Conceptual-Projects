package com.springdemo.demo.rest;

import com.springdemo.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    public List<Student> theStudent;

    @PostConstruct
    public void loadData(){
        theStudent = new ArrayList<>();
        theStudent.add(new Student("Anuj", "Mahajan"));
        theStudent.add(new Student("Sohan", "Kakatkar"));
        theStudent.add(new Student("Divyank", "Agarwal"));
    }
    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudent;
    }

    @GetMapping("/students/{studentId}")
    public Student getSpecificStudent(@PathVariable int studentId){

        if ((studentId >= theStudent.size()) || (studentId < 0)){
            throw  new StudentNotFoundException("Student ID " + studentId +" not found");
        }
        return theStudent.get(studentId);
    }

}
