package com.example.minor_project.request.dto;

import com.example.minor_project.model.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.validation.constraints.NotNull;

@Builder
@AllArgsConstructor
public class CreateStudentRequest {

    @NotNull
    private String name;

    @NotNull
    private int age;

    @NotNull
    private String rollNo;

    public Student toStudent() {
        return Student.builder()
                .name(this.name)
                .age(this.age)
                .rollno(this.rollNo)
                .build();
    }
}
