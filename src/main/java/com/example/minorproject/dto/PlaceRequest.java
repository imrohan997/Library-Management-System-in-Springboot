package com.example.minorproject.dto;

import com.example.minorproject.models.Book;
import com.example.minorproject.models.Request;
import com.example.minorproject.models.RequestStatus;
import com.example.minorproject.models.RequestType;
import com.example.minorproject.models.Student;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlaceRequest {

  @NotNull
  private Integer bookId;

  @NotNull
  private Integer studentId;

  @NotNull
  private String requestType;

  public Request toRequest() {

    return Request.builder()
        .book(bookId == null ? null : Book.builder().id(bookId).build())
        .student(studentId == null ? null : Student.builder().id(studentId).build())
        .requestType(RequestType.valueOf(requestType))
        .requestId(UUID.randomUUID().toString())
        .requestStatus(RequestStatus.PENDING)
        .build();
  }
}
