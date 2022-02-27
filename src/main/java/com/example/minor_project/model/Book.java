package com.example.minor_project.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    @ManyToOne
    @JoinColumn
    Author author;


    @ManyToOne
    @JoinColumn
    Student student;

    @OneToMany(mappedBy = "book")
    List<Transaction> transactionList;

    @OneToMany(mappedBy = "book")
    List<Request> requests;

    @CreationTimestamp
    Date createdOn;
}
