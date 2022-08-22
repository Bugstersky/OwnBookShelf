package com.bugstersky.ownbookshelf.entity;

import com.bugstersky.ownbookshelf.enums.Form;
import com.bugstersky.ownbookshelf.enums.Genre;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table
public class Book {

    @Id
    @GeneratedValue(
            strategy= GenerationType.IDENTITY,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(
            name = "id"
    )
    private Integer id;
    @Column(
            name = "title",
            nullable = false,
            columnDefinition = "TEXT"

    )
    private String title;
    @Column(
            name = "author",
            nullable = false,
            columnDefinition = "TEXT"

    )
    private String author;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "genre",
            nullable = false,
            columnDefinition = " enum('ADVENTURE','CLASSICS','COMIC','DETECTIVE','FANTASY','HORROR',ROMANCE','POETRY')"

    )
    private Genre genre;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "form",
            nullable = false,
            columnDefinition = "enum('SOFTBOOK','HARDBOOK','EBOOK')"
    )
    private Form form;
    @Column(
            name = "language",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String language;

    public Book() {
    }

    public Book(String title, String author, Genre genre, Form form, String language) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.form = form;
        this.language = language;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre=" + genre +
                ", form=" + form +
                ", language='" + language + '\'' +
                '}';
    }
}
