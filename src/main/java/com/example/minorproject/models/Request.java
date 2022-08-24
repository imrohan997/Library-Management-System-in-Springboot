package com.example.minorproject.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Request {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String requestId;

  @JoinColumn
  @ManyToOne
  @JsonIgnoreProperties({"requestsCreated", "bookList"})
  private Student student;

  @JoinColumn
  @ManyToOne
  @JsonIgnoreProperties({"requestsToProcess"})
  private Admin admin;

  @JoinColumn
  @ManyToOne
  @JsonIgnoreProperties({"requestList", "my_student"})
  private Book book;

  @OneToOne(mappedBy = "request")
  @JsonIgnoreProperties("request")
  private Transaction transaction;

  @CreationTimestamp
  private Date requestDate;

  @Enumerated(value = EnumType.STRING)
  private RequestStatus requestStatus;

  @Enumerated(value = EnumType.STRING)
  private RequestType requestType;

  private String adminComment;

  private String systemComment;
}