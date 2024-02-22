package com.datasystem.bookservice.service;


import java.util.List;

import com.datasystem.bookservice.model.AddBookRequest;
import com.datasystem.bookservice.model.BookDto;

public interface BookService {

	List<BookDto> getAllBooks();

	void addBook(AddBookRequest request);

	void rentBook(String isbn, String clientName);
}
