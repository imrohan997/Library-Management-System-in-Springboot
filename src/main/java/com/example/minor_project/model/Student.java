package com.example.minor_project.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int age;

    private String rollno;

    @OneToMany(mappedBy = "student")
    private List<Book> books;

    @OneToMany(mappedBy = "student")
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "student")
    private List<Request> requests;

    @CreationTimestamp
    private Date createdOn;

}
