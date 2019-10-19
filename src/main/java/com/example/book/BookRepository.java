package com.example.book;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findByName(String name);

    void deleteById(Long id);

    //void delete (String name);

}
