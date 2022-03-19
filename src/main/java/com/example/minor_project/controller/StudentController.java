package com.example.minor_project.controller;

import com.example.minor_project.model.Student;
import com.example.minor_project.request.dto.CreateStudentRequest;
import com.example.minor_project.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/createStudent")
    public void createStudent(@RequestBody CreateStudentRequest createRequest) {
        studentService.createStudent(createRequest);
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable("id") Integer id) {
        return studentService.getStudentById(id);
    }

}
