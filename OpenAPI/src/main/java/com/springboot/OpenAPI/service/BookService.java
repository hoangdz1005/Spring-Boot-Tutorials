package com.springboot.OpenAPI.service;

import com.springboot.OpenAPI.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(long id);
    Book createBook(Book book);
    String updateBookById(long id, Book book);
    String deleteAllBooks();
    String deleteBookById(long id);
    Book findBookByName(String name);

}
