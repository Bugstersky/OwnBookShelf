

/***

 - Uncomment code below to push set of data after you start 1 time comment again
 - data is saved in database
**/




//package com.bugstersky.ownbookshelf.sampleData;
//
//import com.bugstersky.ownbookshelf.entity.Book;
//import com.bugstersky.ownbookshelf.enums.Form;
//import com.bugstersky.ownbookshelf.enums.Genre;
//import com.bugstersky.ownbookshelf.repository.BookRepo;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.util.List;
//
//@Component
//public class DbInit {
//    private final BookRepo bookRepo;
//
//    public DbInit(BookRepo bookRepo) {
//        this.bookRepo = bookRepo;
//    }
//
//
//    @PostConstruct
//    public void postBookList (){
//        List<Book> books = List.of(
//                new Book("classic 1", "Michal", Genre.CLASSICS, Form.EBOOK, "ENG"),
//                new Book("KJpsdols", "Adam", Genre.ADVENTURE, Form.EBOOK, "ENG"),
//                new Book("asjdfiasj", "Kornel", Genre.ADVENTURE, Form.EBOOK, "ENG"),
//                new Book("fasijhfja", "Jakub", Genre.ROMANCE, Form.EBOOK, "ENG"),
//                new Book("12", "Pawel", Genre.FANTASY, Form.EBOOK, "PL"),
//                new Book("classic 2", "Jakub", Genre.CLASSICS, Form.EBOOK, "PL"),
//                new Book("32", "Kornel", Genre.DETECTIVE, Form.EBOOK, "PL"),
//                new Book("1333", "Michal", Genre.ROMANCE, Form.EBOOK, "PL"),
//                new Book("1222", "Jakub", Genre.ADVENTURE, Form.EBOOK, "PL"),
//                new Book("23232", "Kacper", Genre.ADVENTURE, Form.EBOOK, "PL"),
//                new Book("classic 3", "Marek", Genre.CLASSICS, Form.EBOOK, "PL"),
//                new Book("4231321", "Donald", Genre.CLASSICS, Form.EBOOK, "PL"),
//                new Book("434321234", "Loland", Genre.FANTASY, Form.EBOOK, "PL"),
//                new Book("33", "Bugs", Genre.ADVENTURE, Form.EBOOK, "PL"),
//                new Book("43243", "Michal", Genre.ADVENTURE, Form.EBOOK, "PL")
//        );
//        bookRepo.saveAll(books);
//    }
//}
