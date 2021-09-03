package com.example.book.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@Table
@EnableJpaAuditing
public class Book implements Serializable {

    @Id
    @SequenceGenerator(name = "book_sequence", sequenceName = "book_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_sequence")
    private Long id; //8-number id
    private String bookName;
    private String author;
    private String publisher;
    public int year;
    private String searchable;
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @CreatedDate
//    private Date create_date ;
    private ZonedDateTime t = ZonedDateTime.now();

    public Book(Long id, String bookName, String author, String publisher, int year, String searchable) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.searchable = searchable;
    }

    public Book(String bookName, String author, String publisher,int year, String searchable) {
        this.bookName = bookName;
        this.author = author;
        this.publisher = publisher;
        this.year = year;

        this.searchable = searchable;
    }

    public Book() {

    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getSearchable() {
        return searchable;
    }

    public void setSearchable(String searchable) {
        this.searchable = searchable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public ZonedDateTime getT() {
        return t;
    }

    public void setT(ZonedDateTime t) {
        this.t = t;
    }
}
