package com.example.modulesearch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable {
    private Long id; //8-number id
    private String bookName;
    private String author;
    private String publisher;
    public int year;
    private String searchable;
    private ZonedDateTime t;


}
