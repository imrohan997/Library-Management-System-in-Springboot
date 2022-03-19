package com.example.minor_project.service;

import com.example.minor_project.model.Author;
import com.example.minor_project.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public Author createOrGetAuthor(Author author) {

        Author authorRetrivedFromDB = authorRepository.getAuthorByEmail(author.getEmail());
        if (authorRetrivedFromDB != null) {
            return authorRetrivedFromDB;
        }

        return authorRepository.save(author);
    }



}
