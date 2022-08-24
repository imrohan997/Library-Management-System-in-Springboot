package com.example.minorproject.service;

import com.example.minorproject.dto.AdminRequest;
import com.example.minorproject.dto.ProcessRequest;
import com.example.minorproject.models.Admin;
import com.example.minorproject.models.Request;
import com.example.minorproject.models.RequestStatus;
import com.example.minorproject.repository.AdminRepository;
import com.example.minorproject.responses.ProcessResponse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

  private static final String REJECTED_STATUS = "Rejected";
  private static final String APPROVED_STATUS = "Approved";

  @Autowired
  AdminRepository adminRepository;

  @Autowired
  RequestService requestService;

  @Autowired
  TransactionService transactionService;

  public Admin createAdmin(AdminRequest adminRequest) {
    return adminRepository.save(adminRequest.to());
  }

  public Admin getAdmin(Integer id) {
    return adminRepository.findById(id).orElse(null);
  }

  public List<Admin> getAllAdmins() {
    return adminRepository.findAll();
  }

  public ProcessResponse processRequest(ProcessRequest processRequest) throws Exception {
    Request request = requestService.getRequestById(processRequest.getRequestId());
    if (request == null) {
      throw new Exception("Request does not exist");
    }

    if (request.getAdmin() == null || request.getAdmin().getId() != processRequest.getAdminId()) {
      throw new Exception("Request is not assigned to this admin " + request.getAdmin().getId());
    }

    if (!RequestStatus.PENDING.equals(request.getRequestStatus())) {
      throw new Exception("Request is already processed");
    }

    if (request.getBook().getMy_student() != null) {
      throw new Exception("Book is already taken by someone else");
    }

    if (RequestStatus.REJECTED.equals(processRequest.getRequestStatus())) {
      request.setRequestStatus(RequestStatus.REJECTED);
      request.setAdminComment(processRequest.getComment());
      request.setSystemComment(REJECTED_STATUS);
      requestService.saveOrUpdateRequest(request);
      return ProcessResponse.builder()
          .systemComment(REJECTED_STATUS)
          .requestStatus(RequestStatus.REJECTED)
          .adminComment(processRequest.getComment())
          .build();
    }


    request.setRequestStatus(RequestStatus.ACCEPTED);
    request.setAdminComment(processRequest.getComment());
    request.setSystemComment(APPROVED_STATUS);
    Request savedRequest = requestService.saveOrUpdateRequest(request);
    transactionService.createTransaction(savedRequest);
    return ProcessResponse.builder()
        .systemComment(APPROVED_STATUS)
        .requestStatus(RequestStatus.ACCEPTED)
        .adminComment(processRequest.getComment())
        .build();
  }
}
