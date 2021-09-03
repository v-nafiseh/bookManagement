package com.example.authmodule.controller;

import com.example.authmodule.model.Book;
import com.example.authmodule.model.Users;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;
import java.util.List;

@RestController
//@RequestMapping("publisher")
public class PublisherController {

    RestTemplate restTemplate = new RestTemplate();
    List<Book> books = null;
    Book book = new Book();

    //returns paginated    true
//    @GetMapping("/get_books/{pageNo}")
//    public List<Book> getBooks(@PathVariable("pageNo") Long pageNo,
//                               @RequestParam("sortField") String sortField,
//                               @RequestParam("sortDirection") String sortDirection) {
//
//
//        try {
//            ResponseEntity<List<Book>> claimResponse = restTemplate.exchange(
//                    "http://localhost:8080/books/page/" + pageNo+ "?sortField="+sortField+"&sortDirection="+sortDirection ,
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

    @GetMapping("/publisher")
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
        modelAndView.setViewName("/publisher/publisher_page");
        modelAndView.addObject("books", books);
        return modelAndView;
    }

    //
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


    @GetMapping("/get_book/{id}")
    public ModelAndView getBook(@PathVariable("id") Long id){
        Book book = null;
        String uri = "http://localhost:8080/books/" ;
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
        modelAndView.setViewName("/publisher/bookPage");
        modelAndView.addObject("book", book);
        return modelAndView;
    }

    //true
//    @PostMapping("add")
//    public void addBook(@RequestBody Book book){
//        String uri = "http://localhost:8080/books/add";
//        restTemplate.postForObject(uri, book, Book.class);
//    }

    @GetMapping("/addBook")
    public ModelAndView addBook(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("publisher/bookAdd");
        return modelAndView;
    }

    @PostMapping(value = "/addBook")
    public ModelAndView addBook(@ModelAttribute("book") Book book) {
        ModelAndView modelAndView = new ModelAndView();
        String uri = "http://localhost:8080/books/add";
        restTemplate.postForObject(uri, book, Book.class);
        modelAndView.setViewName("redirect:/publisher");
        return modelAndView;
    }

    //true
//    @DeleteMapping("delete/{id}")
//    public void deleteBook(@PathVariable("id") Long id){
//        String uri = "http://localhost:8080/books/delete/" + id;
//        restTemplate.delete(uri);
//    }

    @RequestMapping("/deleteBook/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        String uri = "http://localhost:8080/books/delete/" + id;
        restTemplate.delete(uri);
        modelAndView.setViewName("redirect:/publisher");
        return modelAndView;
    }

    //true
    @PutMapping("update/{id}")
    public void updateBook(@PathVariable("id") Long id, @RequestBody Book book){
        URI url = URI.create("http://localhost:8080/books/update/"+id);
        restTemplate.put(url, book);
    }

//    @PutMapping("update/{id}")
//    public ModelAndView updateBook(@PathVariable("id") Long id, @RequestBody Book book){
//        URI url = URI.create("http://localhost:8080/books/update/"+id);
//        restTemplate.put(url, book);
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("/publisher/edit_book");
////        modelAndView.addObject("")
//        return modelAndView;
//    }





}


