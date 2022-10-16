package com.bugstersky.ownbookshelf.repository;

import com.bugstersky.ownbookshelf.entity.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface BookRepository extends JpaRepository<Book, Long> {


}
