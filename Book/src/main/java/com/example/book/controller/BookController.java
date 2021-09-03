package com.example.book.controller;

import com.example.book.model.Book;
import com.example.book.repository.BookRepository;
import com.example.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("books")
public class BookController {

    private final BookService bookService;
    private BookRepository bookRepository;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public List<Book> allBooks(){
        return bookService.getBooks();
    }

    @GetMapping("{id}")
    public Optional<Book> get_book(@PathVariable("id") Long id){
        return bookService.getBook(id);
    }

    @PostMapping("add")
    public void addBook(@RequestBody Book book){
        bookService.addBook(book);
    }

    @DeleteMapping(path ="delete/{id}")
    public void deleteBook(@PathVariable("id") Long id){
        bookService.deleteBook(id);
    }

//    @PutMapping(path = "update/{id}")
//    public void updateBook(@PathVariable("id") Long id,
//                              @RequestParam(required = false) String author,
//                              @RequestParam(required = false) String publisher){
//        bookService.updateStudent(id, author, publisher);
//    }

    @PutMapping(path = "update/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody Book book){
        bookService.update(id, book);
    }

    @GetMapping("/page/{pageNo}")
    public List<Book> findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                   @RequestParam("sortField") String sortField,
                                   @RequestParam("sortDirection") String sortDirection){
        int pageSize = 5;
        Page<Book> page = bookService.findPaginated(pageNo, pageSize, sortField, sortDirection);
        return  page.getContent();
    }

}
