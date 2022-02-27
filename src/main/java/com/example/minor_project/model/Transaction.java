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
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn
    private Book book;

    @ManyToOne
    @JoinColumn
    private Admin admin;

    @ManyToOne
    @JoinColumn
    private Student student;

    @CreationTimestamp
    private Date transactionDate;

    @Enumerated(value = EnumType.STRING)
    private TransactionType type;

    @Enumerated(value = EnumType.STRING)
    private TransactionStatus status;

    private Integer fine;


}
