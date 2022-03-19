package com.example.minor_project.controller;

import com.example.minor_project.request.dto.PlaceRequest;
import com.example.minor_project.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class RequestController {

    @Autowired
    RequestService requestService;

    @PostMapping("/request")
    public String placeRequest(@Valid @RequestBody PlaceRequest placeRequest) {
        return requestService.placeRequest(placeRequest).getExternalId();
    }
}

// Validation checks are performed (not doing db level checks) - 400
// Wrong studentId or bookId - 500 (Foreign key constraint failure)
