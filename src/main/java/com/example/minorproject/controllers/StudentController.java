package com.example.minorproject.controllers;

import com.example.minorproject.dto.PlaceRequest;
import com.example.minorproject.dto.StudentRequest;
import com.example.minorproject.models.Request;
import com.example.minorproject.models.Student;
import com.example.minorproject.service.StudentService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

  @Autowired
  StudentService studentService;


  @PostMapping("/student/create")
  public Student createStudent(@Valid @RequestBody StudentRequest studentCreateRequest){
      return studentService.createStudent(studentCreateRequest);
  }

  @GetMapping("/student/get/{id}")
  public Student getStudent(@PathVariable("id") Integer id){
      Student student = studentService.getStudentById(id);
      return student;
  }

  @PostMapping("/student/request")
  public String placeRequest(@RequestBody @Valid PlaceRequest placeRequest) {
    return studentService.placeRequest(placeRequest);
  }

}
