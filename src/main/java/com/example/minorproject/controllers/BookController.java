package com.example.minorproject.controllers;

import com.example.minorproject.dto.BookFilterQuery;
import com.example.minorproject.dto.BookRequest;
import com.example.minorproject.models.Book;
import com.example.minorproject.responses.BookResponse;
import com.example.minorproject.service.BookService;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

  @Autowired
  BookService bookService;

  @PostMapping("book/create")
  public Book createBook(@RequestBody @Valid BookRequest bookCreateRequest) {
      return bookService.createBook(bookCreateRequest);
  }

  @GetMapping("/book")
  public List<BookResponse> getBook(@RequestParam("filterType") String filterType,
                                    @RequestParam("filterValue") String filterValue){

    switch (BookFilterQuery.valueOf(filterType)){
      case ID:
        return bookService.getBookById(Integer.parseInt(filterValue));
      case GENRE:
        return bookService.getBookByGenre(filterValue);
      case AUTHOR:
        return bookService.getBookByAuthorEmail(filterValue);
      case AVAILABILITY:
        return bookService.getBooksByAvail(Boolean.valueOf(filterValue));
    }

    return null;
  }

}
