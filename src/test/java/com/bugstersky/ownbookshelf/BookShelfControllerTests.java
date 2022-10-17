package com.bugstersky.ownbookshelf;

import com.bugstersky.ownbookshelf.entity.Book;
import com.bugstersky.ownbookshelf.repository.BookRepository;
import com.bugstersky.ownbookshelf.service.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class BookShelfControllerTests {

    @InjectMocks
    BookServiceImpl bookService;

    @Mock
    BookRepository bookRepository;

    @Test
    public void testGetAllBooks() {
        //given
        List<Book> list = new ArrayList<Book>();
        Book b1 = new Book();
        Book b2 = new Book();
        Book b3 = new Book();
        list.add(b1);
        list.add(b2);
        list.add(b3);

        //when
        when(bookRepository.findAll()).thenReturn(list);

        //asert
        List<Book> bookList = bookService.getAllBooks();
        assertEquals(3,bookList.size());
        verify(bookRepository,times(1)).findAll();
    }


    @Test
    public void testSaveBook(){
        Book book = new Book();
        bookService.saveBook(book);
        verify(bookRepository,times(1)).save(book);
    }


}
