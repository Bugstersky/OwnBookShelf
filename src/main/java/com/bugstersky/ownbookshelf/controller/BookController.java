package com.bugstersky.ownbookshelf.controller;

import com.bugstersky.ownbookshelf.entity.Book;
import com.bugstersky.ownbookshelf.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/list")
    String getBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }

    @GetMapping("/addBookForm")
    public ModelAndView addBookForm() {
        ModelAndView mav = new ModelAndView("book-form");
        Book newBook = new Book();
        mav.addObject("book", newBook);
        return mav;
    }

    @PostMapping("/saveBook")
    public String saveBook(@Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "book-form";
        }
        bookService.saveBook(book);
        return "redirect:/api/v1/list";
    }

    // TODO:
    //  IMPORTANT-> Change book to transfer object , use indirect form of entity
    //  LESS IMPORTANT -> new form for update books; readme; change text-inputs -> select: option

    @GetMapping("/editBookForm/{id}")
    public ModelAndView showUpdateForm(@PathVariable("id") Long bookId) {
        ModelAndView mav = new ModelAndView("book-form");
        mav.addObject("book",bookService.getBookById(bookId));
        return mav;
    }

    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
        Book book = bookService.getBookById(bookId);
        bookService.deleteBook(book);
        return "redirect:/api/v1/list";
    }


}
