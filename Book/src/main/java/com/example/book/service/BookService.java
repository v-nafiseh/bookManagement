package com.example.book.service;

import com.example.book.model.Book;
import com.example.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public void deleteBook(Long id) {
        boolean exists = bookRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("book with this id not exists!!");
        }
        bookRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(Long id, String author, String publisher) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Book with id " + id + "does not exist"));
        if (author != null && author.length() > 0 && !Objects.equals(book.getAuthor(), author)) {
            book.setAuthor(author);
        }

        book.setPublisher(publisher);

    }

    public Optional<Book> getBook(Long id) {
        boolean exists = bookRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("book does not exist");
        }
        return bookRepository.findById(id);
    }

    public Page<Book> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection){
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ?  Sort.by(sortField).ascending():
                Sort.by(sortField).descending();
        Pageable pagable = PageRequest.of(pageNo - 1, pageSize, sort);
        return bookRepository.findAll(pagable);
    }

    @Transactional
    public void update(Long id, Book book) {
        Book inbook = bookRepository.findBookById(id);
        inbook.setPublisher(book.getPublisher());
        inbook.setAuthor(book.getAuthor());


    }
}
