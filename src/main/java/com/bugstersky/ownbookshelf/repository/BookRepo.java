package com.bugstersky.ownbookshelf.repository;

import com.bugstersky.ownbookshelf.entity.Book;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepo extends CrudRepository<Book,Integer> {

    Book findBookById(Integer id);

}
