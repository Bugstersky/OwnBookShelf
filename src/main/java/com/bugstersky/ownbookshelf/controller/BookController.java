package com.bugstersky.ownbookshelf.controller;

import com.bugstersky.ownbookshelf.entity.Book;
import com.bugstersky.ownbookshelf.repository.BookRepo;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController implements ErrorController {
    private final static String PATH = "/error";
    private final BookRepo bookRepo;

    public BookController(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @GetMapping("/list")
    public List<Book> getAllBooks(){
        return bookRepo.findAll();
    }

    @GetMapping("/find/{id}")
    public Optional<Book> getBookById(@PathVariable Integer id){
        return bookRepo.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomerById(@PathVariable Integer id) {
        if (id == null) {
            throw new NullPointerException("Record not found");
        }
        bookRepo.deleteById(id);
    }

}
