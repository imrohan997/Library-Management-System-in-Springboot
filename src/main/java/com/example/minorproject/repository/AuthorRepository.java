package com.example.minorproject.repository;

import com.example.minorproject.models.Author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {

  @Query("Select a from Author a where a.email=:email")
  public Author findByEmailId(@Param("email") String email);
}
