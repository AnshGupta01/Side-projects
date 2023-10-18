package com.data.rest.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRestAutomaticApplication implements CommandLineRunner {

    @Autowired
    private BookRepo bookRepo;
    @Override
    public void run(String... args) throws Exception {

        Book book = new Book();
        book.setTitle("Ansh's book");
        book.setContent("Hello hello");

        Book book1 = new Book();
        book1.setTitle("Ansh's 2nd Book");
        book1.setContent("Hello hello content from second book");

        this.bookRepo.save(book1);
        this.bookRepo.save(book);

    }

    public static void main(String[] args) {
        SpringApplication.run(SpringRestAutomaticApplication.class, args);

    }

}
