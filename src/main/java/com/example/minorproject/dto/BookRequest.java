package com.example.minorproject.dto;

import com.example.minorproject.models.Author;
import com.example.minorproject.models.Book;
import com.example.minorproject.models.Genre;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookRequest {

  @NotNull
  String bookName;

  @NotNull
  String authorName;

  @NotNull
  @Email
  String authorEmail;

  @NotNull
  Genre genre;


  String authorWebsite;

  public Book toBook(){
    return Book.builder()
        .name(this.bookName)
        .genre(this.genre)
        .build();
  }

  public Author toAuthor(){
    return Author.builder()
        .name(this.authorName)
        .email(this.authorEmail)
        .website(this.authorWebsite)
        .build();
  }

}
