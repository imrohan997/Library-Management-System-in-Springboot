package com.example.minor_project.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn
    private Student student;

    @ManyToOne
    @JoinColumn
    private Admin admin;

    @ManyToOne
    @JoinColumn
    private Book book;

    @CreationTimestamp
    private Date requestDate;

    @Enumerated(value = EnumType.STRING)
    private RequestStatus status;


}
