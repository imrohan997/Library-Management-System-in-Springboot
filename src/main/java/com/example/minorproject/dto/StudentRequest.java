package com.example.minorproject.dto;

import com.example.minorproject.models.Student;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentRequest {

  @NotNull
  private String name;

  @Min(1)
  private int age;

  @NotNull
  private String rollNo;

  public Student to() {
    return Student.builder()
        .age(this.getAge())
        .name(this.getName())
        .rollNo(this.getRollNo())
        .build();
  }
}
