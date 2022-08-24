package com.example.minorproject.service;

import com.example.minorproject.models.Book;
import com.example.minorproject.models.Request;
import com.example.minorproject.models.RequestType;
import com.example.minorproject.models.Student;
import com.example.minorproject.models.Transaction;
import com.example.minorproject.models.TransactionStatus;
import com.example.minorproject.repository.TransactionRepository;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

  @Autowired
  BookService bookService;

  @Autowired
  TransactionRepository transactionRepository;

  @Value("${book.allotted.max_days}")
  int allottedDays;

  @Value("${book.fine.per_day}")
  int finePerDay;

  public String createTransaction(Request request) throws Exception {
    Transaction transaction = Transaction.builder()
        .externalTransactionId(UUID.randomUUID().toString())
        .request(request)
        .transactionStatus(TransactionStatus.PENDING)
        .fine(calculateFine(request))
        .build();

    Transaction savedTxn = transactionRepository.save(transaction);
    try {

      if (RequestType.ISSUE.equals(request.getRequestType())) {
        Book requestedBook = request.getBook();
        Student student = request.getStudent();
        requestedBook.setMy_student(student);
        bookService.saveOrUpdateBook(requestedBook);

      } else if (RequestType.RETURN.equals(request.getRequestType())) {
        Book requestedBook = request.getBook();
        requestedBook.setMy_student(null);
        bookService.saveOrUpdateBook(requestedBook);
      }

      savedTxn.setTransactionStatus(TransactionStatus.PASSED);
      return transactionRepository.save(savedTxn).getExternalTransactionId();
    } catch (Exception e) {
      savedTxn.setTransactionStatus(TransactionStatus.FAILED);
      return transactionRepository.save(savedTxn).getExternalTransactionId();
    }
  }

  private Double calculateFine(Request request) throws Exception {
    if (RequestType.ISSUE.equals(request.getRequestType())) {
      return null;
    }
    //TODO
    List<Transaction> transactionList =
        transactionRepository.findTransactionByRequest_Book_IdAndTransactionStatusOrderByTransactionDateDesc(request.getBook().getId(),
            TransactionStatus.PASSED);

    Transaction transaction = transactionList.get(0);

    if (!RequestType.ISSUE.equals(transaction.getRequest().getRequestType())) {
      throw new Exception("Last txn is not an issue txn");
    }
    long timeOfIssueInMillis = transaction.getTransactionDate().getTime();
    long timeDiff = System.currentTimeMillis() - timeOfIssueInMillis;
    long noOfDaysPassed = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);

    double fine = 0.0;

    if (noOfDaysPassed > allottedDays) {
      fine = (noOfDaysPassed - allottedDays) * finePerDay;
    }
    return fine;
  }
}
