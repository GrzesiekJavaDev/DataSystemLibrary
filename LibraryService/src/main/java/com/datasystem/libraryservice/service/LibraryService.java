package com.datasystem.libraryservice.service;

import java.util.List;

import com.datasystem.libraryservice.model.entity.Book;

public interface LibraryService {

	List<Book> getAllBorrowedBooks();

	void borrowBook(String isbn, String clientName);
}
