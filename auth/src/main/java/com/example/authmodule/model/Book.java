package com.example.authmodule.model;


import java.time.LocalDate;
import java.time.ZonedDateTime;

public class Book {
    private Long id; //8-number id
    private String bookName;
    private String author;
    private String publisher;
    public int year;
    private String searchable;
    private ZonedDateTime t;

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

    public void setYear(int year){
        this.year = year;
    }

    public int getYear(){
        return year;
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

    public ZonedDateTime getT() {
        return t;
    }

    public void setT(ZonedDateTime t) {
        this.t = t;
    }
}
