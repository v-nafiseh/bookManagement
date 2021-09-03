package com.example.authmodule.controller;

import com.example.authmodule.model.Book;
import com.example.authmodule.model.BookWrapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
//@RequestMapping("user")
public class UserController {
    RestTemplate restTemplate = new RestTemplate();
    List<Book> books = null;
    private BookWrapper bookWrapper;

//    @GetMapping("get_books/{pageNo}")
//    public List<Book> getBooks(@PathVariable("pageNo") Long pageNo) {
//
//        try {
//            ResponseEntity<List<Book>> claimResponse = restTemplate.exchange(
//                    "http://localhost:8080/books/page/" + pageNo,
//                    HttpMethod.GET,
//                    null,
//                    new ParameterizedTypeReference<List<Book>>() {
//                    });
//            if (claimResponse != null && claimResponse.hasBody()) {
//                books = claimResponse.getBody();
//
//            }
//        } catch (RestClientException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return books;
//    }

    @GetMapping("/user")
    public ModelAndView getBooks() {


        try {
            ResponseEntity<List<Book>> claimResponse = restTemplate.exchange(
                    "http://localhost:8080/books/all",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Book>>() {
                    });
            if (claimResponse != null && claimResponse.hasBody()) {
                books = claimResponse.getBody();

            }
        } catch (RestClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/user_page");
        modelAndView.addObject("books", books);
        return modelAndView;
    }
    //true
//    @GetMapping("get_book/{id}")
//    public Book getBook(@PathVariable("id") Long id){
//        Book book = null;
//        String uri = "http://localhost:8080/books/" ;
//        try {
//            ResponseEntity<Book> claimResponse = restTemplate.exchange(
//                    uri + id,
//                    HttpMethod.GET,
//                    null,
//                    new ParameterizedTypeReference<Book>() {
//                    });
//            if (claimResponse != null && claimResponse.hasBody()) {
//                book = claimResponse.getBody();
//
//            }
//        } catch (RestClientException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return book;
//    }

    @GetMapping("/user/get_book/{id}")
    public ModelAndView getBook(@PathVariable("id") Long id) {
        Book book = null;
        String uri = "http://localhost:8080/books/";
        try {
            ResponseEntity<Book> claimResponse = restTemplate.exchange(
                    uri + id,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<Book>() {
                    });
            if (claimResponse != null && claimResponse.hasBody()) {
                book = claimResponse.getBody();

            }
        } catch (RestClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/bookPage");
        modelAndView.addObject("book", book);
        return modelAndView;
    }


    @GetMapping("/search")
    public BookWrapper search(@RequestParam("searchable") String searchable){
       String uri = "http://localhost:8081/search?searchable="+searchable;
        try {
            ResponseEntity<BookWrapper> claimResponse = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<BookWrapper>() {
                    });
            if (claimResponse != null && claimResponse.hasBody()) {
                bookWrapper = claimResponse.getBody();

            }
        } catch (RestClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return bookWrapper;
    }

    @GetMapping("/filter")
    public BookWrapper filterBook(@RequestParam("name") String name){
        String uri = "http://localhost:8081/filter?name="+name;
        try {
            ResponseEntity<BookWrapper> claimResponse = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<BookWrapper>() {
                    });
            if (claimResponse != null && claimResponse.hasBody()) {
                bookWrapper = claimResponse.getBody();

            }
        } catch (RestClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return bookWrapper;
    }


    }






