package com.example.minor_project.controller;

import com.example.minor_project.model.Book;
import com.example.minor_project.request.dto.CreateBookRequest;
import com.example.minor_project.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class BookController {

    @Autowired
    BookService bookService;


    @PostMapping("/createBook")
    public void createBook(@Valid @RequestBody CreateBookRequest createBookRequest) {
        bookService.createBook(createBookRequest);
    }

    @GetMapping("/getBook/{id}")
    public Book getBookById(@PathVariable("id") Integer id) {
        return bookService.findBookById(id);
    }
}
