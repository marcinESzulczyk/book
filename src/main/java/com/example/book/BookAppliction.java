package com.example.book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class BookAppliction implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(BookAppliction.class);

    @Autowired
    private BookRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(BookAppliction.class, args);
    }
    @Transactional
    @Override
    public void run(String... args) {

        log.info("BookApplication...");

        repository.save(new Book("Java"));
        repository.save(new Book("Node"));
        repository.save(new Book("Python"));

        System.out.println("\nfindAll()");
        repository.findAll().forEach(x -> System.out.println(x));

        System.out.println("\nfindById(1L)");
        repository.findById(1l).ifPresent(x -> System.out.println(x));

        System.out.println("\nfindByName('Node')");
        repository.findByTitle("Node").forEach(x -> System.out.println(x));

        System.out.println("\ndeleteById('Node')");
        repository.deleteById(2l);

        System.out.println("\ndeleteByName('Java')");
        repository.deleteByTitle("Java");

        System.out.println("\nfindAll()");
        repository.findAll().forEach(x -> System.out.println(x));



    }

}
