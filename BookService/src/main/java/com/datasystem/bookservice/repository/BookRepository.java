package com.datasystem.bookservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.datasystem.bookservice.model.entity.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
}
