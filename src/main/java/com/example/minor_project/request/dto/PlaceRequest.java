package com.example.minor_project.request.dto;

import com.example.minor_project.model.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@AllArgsConstructor
public class PlaceRequest {


    private Integer studentId;

    private Integer bookId;
    @NotNull
    private String requestType;


    public Request toRequest() {
        return Request.builder()
                .externalId(UUID.randomUUID().toString())
                .student(studentId == null ? null : Student.builder().id(studentId).build())
                .book(bookId == null ? null : Book.builder().id(bookId).build())
                .requestStatus(RequestStatus.PENDING)
                .requestType(RequestType.ISSUE)
                .build();

    }

}
