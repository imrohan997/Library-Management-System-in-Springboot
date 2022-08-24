package com.example.minorproject.repository;

import com.example.minorproject.models.Book;
import com.example.minorproject.models.Genre;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

  @Query("select b from Book b where b.genre = :genre")
    // --> mysql
  List<Book> getBooksInGenre(Genre genre);

  @Query(value = "select * from book b where b.genre = ?1", nativeQuery = true)
  List<Book> getBooksInGenreSql(String genre);


  @Query(value = "select * from book b join author a on b.author_id = a.id where a.email = ?1", nativeQuery = true)
  List<Book> getBookByAuthorEmail(String authorEmail);

  @Query(value = "select * from book b where my_student_id is not null", nativeQuery = true)
  List<Book> getBookIfAvailable();
}
