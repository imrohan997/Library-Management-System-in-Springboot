package com.example.minor_project.request.dto;

import com.example.minor_project.model.Author;
import com.example.minor_project.model.Book;
import com.example.minor_project.model.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.StringUtils;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateBookRequest {

    @NotNull
    private String bookName;

    @NotNull
    private String genre;


    @NotNull
    private String authorName;

    @NotNull
    @Email
    private String authorEmail;

    private String authorWebsite;

    public Book toBook() {
        return Book.builder().name(this.bookName).genre(Enum.valueOf(Genre.class, this.genre.toUpperCase())).build();
    }

    public Author toAuthor() {
        return Author.builder().name(this.authorName).email(this.authorEmail).website(this.authorWebsite).build();
    }


}
