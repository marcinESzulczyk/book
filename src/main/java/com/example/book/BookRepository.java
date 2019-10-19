package com.example.book;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findByTitle(String title);

    void deleteById(Long id);

    void deleteByTitle(String title);

}
