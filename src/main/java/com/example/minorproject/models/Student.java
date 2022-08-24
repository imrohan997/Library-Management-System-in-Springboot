package com.example.minorproject.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(nullable = false)
  private String name;
  private int age;

  @Column(unique = true, nullable = false)
  private String rollNo;

  @OneToMany(mappedBy = "my_student")
  @JsonIgnoreProperties({"my_student", "requestList"})
  private List<Book> bookList;

  @OneToMany(mappedBy = "student")
  @JsonIgnoreProperties({"student", "admin", "book", "transaction"})
  private List<Request> requestsCreated;

  @CreationTimestamp
  private Date createdOn;

}