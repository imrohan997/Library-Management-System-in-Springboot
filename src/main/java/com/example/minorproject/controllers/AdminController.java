package com.example.minorproject.controllers;

import com.example.minorproject.dto.AdminRequest;
import com.example.minorproject.dto.ProcessRequest;
import com.example.minorproject.models.Admin;
import com.example.minorproject.responses.ProcessResponse;
import com.example.minorproject.service.AdminService;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

  @Autowired
  AdminService adminService;

  @PostMapping("/admin/create")
  public Admin createAdmin( @Valid @RequestBody AdminRequest adminRequest){
    return adminService.createAdmin(adminRequest);
  }

  @GetMapping("/admin/get/{id}")
  public Admin getAdmin(@PathVariable("id") Integer id){
    return adminService.getAdmin(id);
  }

  @GetMapping("/admin/getAll")
  public List<Admin> getAllAdmins(){
    return adminService.getAllAdmins();
  }

  @PostMapping("/admin/process")
  public ProcessResponse processRequests(@Valid @RequestBody ProcessRequest placeRequest) throws Exception {
    return adminService.processRequest(placeRequest);
  }
}
