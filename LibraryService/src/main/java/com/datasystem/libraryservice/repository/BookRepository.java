package com.datasystem.libraryservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.datasystem.libraryservice.model.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
	List<Book> findByBorrowerIsNotNull();
}
