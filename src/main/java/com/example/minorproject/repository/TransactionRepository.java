package com.example.minorproject.repository;

import com.example.minorproject.models.Transaction;
import com.example.minorproject.models.TransactionStatus;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

  List<Transaction> findTransactionByRequest_Book_IdAndTransactionStatusOrderByTransactionDateDesc(int bookId, TransactionStatus transactionStatus);
}
