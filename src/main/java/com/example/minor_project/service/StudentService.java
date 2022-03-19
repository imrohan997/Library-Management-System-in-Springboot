package com.example.minor_project.service;

import com.example.minor_project.model.Student;
import com.example.minor_project.repository.StudentRepository;
import com.example.minor_project.request.dto.CreateStudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void createStudent(CreateStudentRequest createStudentRequest) {
        studentRepository.save(createStudentRequest.toStudent());
    }

    public Student getStudentById(Integer id){
       return studentRepository.findById(id).orElse(null);
    }
}
