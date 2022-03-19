package com.example.minor_project.service;

import com.example.minor_project.model.Author;
import com.example.minor_project.model.Book;
import com.example.minor_project.repository.BookRepository;
import com.example.minor_project.request.dto.CreateBookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorService authorService;

    public void createBook(CreateBookRequest createBookRequest) {

        Author author = createBookRequest.toAuthor();
        author = authorService.createOrGetAuthor(author);

        Book book = createBookRequest.toBook();
        book.setAuthor(author);

        bookRepository.save(book);
    }

    public Book findBookById(int id) {
        return bookRepository.findById(id).orElse(null);
    }
}
