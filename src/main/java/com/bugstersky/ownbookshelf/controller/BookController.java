package com.bugstersky.ownbookshelf.controller;

import com.bugstersky.ownbookshelf.entity.Book;
import com.bugstersky.ownbookshelf.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/api/v1")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/list")
    String getBooks(Model model) {
        List<Book> allBooks = bookRepository.findAll();
        model.addAttribute("books", allBooks);
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
        bookRepository.save(book);
        return "redirect:/api/v1/list";
    }

    // TODO: new form for update books; readme; change text-inputs -> select: option

    @GetMapping("/editBookForm/{id}")
    public ModelAndView showUpdateForm(@PathVariable("id") Long bookId) {
        ModelAndView mav = new ModelAndView("book-form");
        Optional<Book> book = bookRepository.findById(bookId);
        mav.addObject("book",book);

        return mav;
    }

    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book id" + bookId));
        bookRepository.delete(book);
        return "redirect:/api/v1/list";
    }


}
