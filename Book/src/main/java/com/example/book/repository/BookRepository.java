package com.example.book.repository;

import com.example.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
//    @Query("SELECT b from Book where b.id = id")
//    public Book findId(Long id);

    @Query("select b from Book b where b.id = :id")
    public Book findBookById(Long id);
}
