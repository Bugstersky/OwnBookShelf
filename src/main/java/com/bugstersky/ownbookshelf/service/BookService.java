package com.bugstersky.ownbookshelf.service;

import com.bugstersky.ownbookshelf.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> getAllBooks();
    Book saveBook(Book book);
    Book getBookById(Long id);
    void deleteBook(Book book);
}
