package com.example.minorproject.responses;

import com.example.minorproject.models.Author;
import com.example.minorproject.models.Genre;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {

  private int id;
  private String name;

  private Genre genre;

  @JsonIgnoreProperties("bookList")
  private Author author;
}