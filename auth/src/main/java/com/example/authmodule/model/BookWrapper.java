package com.example.authmodule.model;

import java.io.Serializable;
import java.util.List;

public class BookWrapper implements Serializable {
    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

}
