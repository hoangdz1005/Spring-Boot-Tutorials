package com.springboot.OpenAPI.service;

import com.springboot.OpenAPI.model.Book;
import com.springboot.OpenAPI.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;
    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public String updateBookById(long id, Book book) {
        Book book_ = bookRepository.findById(id).get();
        book_.setName(book.getName());
        book_.setDescription(book.getDescription());
        book_.setPrice(book.getPrice());
        bookRepository.save(book_);
        return "Book id " + id + "has been updated!";
    }

    @Override
    public String deleteAllBooks() {
        bookRepository.deleteAll();
        return "All books have been deleted!";
    }

    @Override
    public String deleteBookById(long id) {
        bookRepository.deleteById(id);
        return "Book id " + id + " have been deleted!";
    }

    @Override
    public Book findBookByName(String name) {
        return bookRepository.findBookByName(name);
    }

}
