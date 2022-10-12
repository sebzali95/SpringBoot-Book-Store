package com.example.bookstore;

import com.example.bookstore.model.Book;
import com.example.bookstore.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
@RequiredArgsConstructor
public class BookStoreApplication implements CommandLineRunner {


    private final BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Book book1 = Book.builder()
                .name("Yuzliuklerin efendisi")
                .author("J.R.R Tolkien")
                .price(10.0)
                .stock(10)
                .build();
        Book book2 = Book.builder()
                .name("Baslangic")
                .author("Dan Brown")
                .price(11.1)
                .stock(10)
                .build();
        Book book3 = Book.builder()
                .name("Tanrinin forumu")
                .author("Santos")
                .price(15.5)
                .stock(10)
                .build();

        bookRepository.saveAll(Arrays.asList(book1,book2,book3));
    }
}
