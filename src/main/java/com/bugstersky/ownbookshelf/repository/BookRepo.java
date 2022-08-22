package com.bugstersky.ownbookshelf.repository;

import com.bugstersky.ownbookshelf.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepo extends JpaRepository<Book,Integer> {


}
