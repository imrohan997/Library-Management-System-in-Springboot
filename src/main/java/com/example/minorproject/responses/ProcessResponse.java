package com.example.minorproject.responses;

import com.example.minorproject.models.RequestStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProcessResponse {
  private RequestStatus requestStatus;
  private String systemComment;
  private String adminComment;
}
