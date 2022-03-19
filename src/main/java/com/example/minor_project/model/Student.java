package com.example.minor_project.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int age;

    @Column(unique = true)
    private String rollno;

    @OneToMany(mappedBy = "student")
    private List<Book> books;


    @OneToMany(mappedBy = "student")
    private List<Request> requests;

    @CreationTimestamp
    private Date createdOn;

}
