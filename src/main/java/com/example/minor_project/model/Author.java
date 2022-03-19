package com.example.minor_project.model;

import lombok.*;
import org.springframework.jmx.export.annotation.ManagedNotifications;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(unique = true)
    private String email;

    private String website;

    @OneToMany(mappedBy = "author")
    private List<Book> books;


}
