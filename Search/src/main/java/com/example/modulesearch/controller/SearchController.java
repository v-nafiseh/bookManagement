package com.example.modulesearch.controller;

import com.example.modulesearch.model.Book;
import com.example.modulesearch.service.SearchService;
import com.example.modulesearch.wrapper.BookWrapper;
import lombok.Data;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@Data
public class SearchController {


    private final RestTemplate rest;

    private static BookWrapper bookWrapper = new BookWrapper();

    SearchService searchService = new SearchService();

    public SearchController(RestTemplateBuilder restTemplateBuilder)
    {
        rest = restTemplateBuilder.build();
    }
    public static List<Book> books = null;



    //test : get book with id 1
//    @GetMapping("/book")
//    public Book getBooks(){
//       Book book = rest.getForObject("http://localhost:8080/books" + "/1", Book.class);
//       return  book;
//    }

//    @GetMapping("/all")
//    public ResponseEntity<Book[]> getBooks(){
//        ResponseEntity<Book[]> result = rest.getForEntity("http://localhost:8080/books/all", Book[].class);
//        return result;
//    }

    //wrong
    @GetMapping("all")
    public BookWrapper getBooks(){
        String url = "http://localhost:8080/books/all";
        ResponseEntity<List<Book>> response = rest.exchange(url,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<List<Book>>() {
                });

        bookWrapper.setBooks(response.getBody());
//        bookWrapper = (BookWrapper) response.getBody();
        SearchService.setBookWrapper(bookWrapper);
        return bookWrapper;
    }


    //correct
//    @GetMapping("/all")
//    public List<Book> getBooks() {
//        RestTemplate restTemplate = new RestTemplate();
//
////        List<Book> books = null;
//        try {
//            ResponseEntity<List<Book>> claimResponse = restTemplate.exchange(
//                    "http://localhost:8080/books/all",
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

    @GetMapping("/search")
    public BookWrapper search(@RequestParam("searchable") String searchable){
        getBooks();
        BookWrapper search_results = searchService.search(searchable);
        return search_results;
    }

    //filter by publisher or author or publish year
    @GetMapping("/filter")
    public BookWrapper filterBook(@RequestParam("name") String name){
        getBooks();
        BookWrapper response = searchService.filter(name);
        return response;
    }
}
