package com.example.modulesearch.service;

import com.example.modulesearch.controller.SearchController;
import com.example.modulesearch.model.Book;
import com.example.modulesearch.wrapper.BookWrapper;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {

    @Setter
    @Getter
    private static BookWrapper bookWrapper;


//    List<Book> books = SearchController.books;
    public BookWrapper search(String searchWords) {
        ArrayList<Book> search_results = new ArrayList<>();
        BookWrapper searchBookArrayResponse = new BookWrapper();
        String[] searchArray = searchWords.split(",");

        for (Book bookResponse : bookWrapper.getBooks())
            for(String searchWord : searchArray)
                if(bookResponse.getSearchable().contains(searchWord))
                    search_results.add(bookResponse);

        searchBookArrayResponse.setBooks(search_results);
        return searchBookArrayResponse;
}

    public BookWrapper filter(String filterMode) {
        ArrayList<Book> search_results = new ArrayList<>();
        BookWrapper searchBookArrayResponse = new BookWrapper();
        String[] filterArray = filterMode.split("-");
        System.out.println(filterArray.length);

        if(filterArray.length<2)
            for (Book bookResponse : bookWrapper.getBooks())
                if (bookResponse.getPublisher().equals(filterMode) || bookResponse.getAuthor().equals(filterMode))
                    search_results.add(bookResponse);
        if(filterArray.length>1)
            for (Book bookResponses : bookWrapper.getBooks())
                if (Integer.parseInt((filterArray[0])) <= bookResponses.getYear()
                        && bookResponses.getYear() <= Integer.parseInt(filterArray[1]))
                    search_results.add(bookResponses);

        searchBookArrayResponse.setBooks(search_results);
        return searchBookArrayResponse;
    }


//    public List<Book> search(String searchable) {
//        String[] searchArray = searchable.split(",");
//        ArrayList<Book> search_results = new ArrayList<>();
//
//
//        for (Book book : books)
//            for(String searchWord : searchArray)
//                if(book.getSearchable().contains(searchWord))
//                    search_results.add(book);
//        return search_results;
//
//
//    }
}
