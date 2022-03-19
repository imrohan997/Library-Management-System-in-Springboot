package com.example.minor_project.service;

import com.example.minor_project.model.Request;
import com.example.minor_project.repository.RequestRepository;
import com.example.minor_project.request.dto.PlaceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestService {


    @Autowired
    RequestRepository requestRepository;

    public Request placeRequest(PlaceRequest placeRequest) {
        return requestRepository.save(placeRequest.toRequest());
    }
}
