package com.example.minorproject.service;

import com.example.minorproject.dto.BookRequest;
import com.example.minorproject.models.Author;
import com.example.minorproject.models.Book;
import com.example.minorproject.repository.BookRepository;
import com.example.minorproject.responses.BookResponse;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

  @Autowired
  BookRepository bookRepository;

  @Autowired
  AuthorService authorService;

  public Book createBook(BookRequest bookCreateRequest) {

      Author author = authorService.createOrGetAuthor(bookCreateRequest.toAuthor());
      Book book = bookCreateRequest.toBook();
      book.setAuthor(author);

      return bookRepository.save(book);
  }


  public Book saveOrUpdateBook(Book book){
    return bookRepository.save(book);
  }

  public List<BookResponse> getBookById(int id) {
    Book book = bookRepository.findById(id).orElse(null);
    return Collections.singletonList(book.to());
  }

  public List<BookResponse> getBookByGenre(String genre){
    return bookRepository.getBooksInGenreSql(genre).stream()
        .map(Book::to)
        .collect(Collectors.toList());
  }

  public List<BookResponse> getBookByAuthorEmail(String authorEmail){
    return bookRepository.getBookByAuthorEmail(authorEmail).stream()
        .map(Book::to)
        .collect(Collectors.toList());
  }

  public List<BookResponse> getBooksByAvail(boolean avail){
    return bookRepository.getBookIfAvailable().stream()
        .map(Book::to)
        .collect(Collectors.toList());
  }
}
