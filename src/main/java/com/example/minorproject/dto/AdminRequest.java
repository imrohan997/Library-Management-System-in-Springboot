package com.example.minorproject.dto;

import com.example.minorproject.models.Admin;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AdminRequest {

  @NotNull
  private String name;

  @NotNull
  @Email
  private String email;

  public Admin to(){
    return Admin.builder()
        .name(this.getName())
        .email(this.getEmail())
        .build();
  }

}
