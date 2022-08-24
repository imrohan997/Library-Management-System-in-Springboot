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
public class Transaction {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  // Only for outside world
  private String externalTransactionId; // like 501a26b4-0366-44ec-b537-c3d39d51f67c

  @OneToOne
  @JoinColumn
  @JsonIgnoreProperties("transaction")
  private Request request; // request_id will be acting as a foreign key in the transaction table

  @CreationTimestamp
  private Date transactionDate;

  @Enumerated(value = EnumType.STRING)
  private TransactionStatus transactionStatus;

  private Double fine;
}