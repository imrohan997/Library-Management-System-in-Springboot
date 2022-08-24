package com.example.minorproject.service;

import com.example.minorproject.dto.PlaceRequest;
import com.example.minorproject.models.Admin;
import com.example.minorproject.models.Request;
import com.example.minorproject.repository.RequestRepository;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestService {

  @Autowired
  RequestRepository requestRepository;

  public Request getRequestById(Integer id){
    return requestRepository.findById(id).orElse(null);
  }

  public Request saveOrUpdateRequest(Request request){
    return requestRepository.save(request);
  }
}