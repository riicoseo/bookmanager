package com.fastcampus.jpa.bookmanager.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.annotation.sql.DataSourceDefinitions;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Book extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String category;

    private Long authorId;

   // private Long publisherId;

   @OneToOne(mappedBy = "book")
   @ToString.Exclude
    private BookReviewInfo bookReviewInfo;

   @OneToMany
   @JoinColumn(name="book_id")
   @ToString.Exclude
    private List<Review> reviews = new ArrayList<>();

   @ManyToOne
   @ToString.Exclude
    private Publisher publisher;

//   @ManyToMany
//   @ToString.Exclude
//    private List<Author> authors = new ArrayList<>();
@OneToMany
@JoinColumn(name="book_id")
@ToString.Exclude
private List<BookAndAuthor> bookAndAuthors = new ArrayList<>();

public void addBookAndAuthors(BookAndAuthor... bookAndAuthors){
        Collections.addAll(this.bookAndAuthors, bookAndAuthors);
    }

}
