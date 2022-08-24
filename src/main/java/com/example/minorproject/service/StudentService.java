package com.example.minorproject.service;

import com.example.minorproject.dto.PlaceRequest;
import com.example.minorproject.dto.StudentRequest;
import com.example.minorproject.models.Admin;
import com.example.minorproject.models.Request;
import com.example.minorproject.models.Student;
import com.example.minorproject.repository.StudentRepository;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  @Autowired
  StudentRepository studentRepository;

  @Autowired
  AdminService adminService;

  @Autowired
  RequestService requestService;

  public Student createStudent(StudentRequest studentRequest){
    return studentRepository.save(studentRequest.to());
  }

  public Student getStudentById(int id) {
    return studentRepository.findById(id).orElse(null);
  }


  public String placeRequest(PlaceRequest placeRequest){
    List<Admin> admins = adminService.getAllAdmins();

    Admin admin = admins.stream()
        .min(Comparator.comparingInt(a -> a.getRequestToProcess().size()))
        .orElse(null);

    Request request =placeRequest.toRequest();
    request.setAdmin(admin);

    return requestService.saveOrUpdateRequest(request).getRequestId();
  }
}

