package com.example.minor_project.repository;

import com.example.minor_project.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepository extends JpaRepository<Author, Integer> {


    @Query("Select a from Author a where a.email= :email")
    public Author getAuthorByEmail(String email);
}
