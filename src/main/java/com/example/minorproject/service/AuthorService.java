package com.example.minorproject.service;

import com.example.minorproject.models.Author;
import com.example.minorproject.repository.AuthorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

  @Autowired
  AuthorRepository authorRepository;

  public Author createOrGetAuthor(Author author){
    Author authorFromRepo = authorRepository.findByEmailId(author.getEmail());
    if(authorFromRepo ==  null){
       return authorRepository.save(author);
    }
    return authorFromRepo;
  }

  private Author getAuthorByEmail(String email){
    return authorRepository.findByEmailId(email);
  }
}
