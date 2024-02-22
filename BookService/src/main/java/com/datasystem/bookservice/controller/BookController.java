package com.datasystem.bookservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.datasystem.bookservice.model.AddBookRequest;
import com.datasystem.bookservice.model.BookDto;
import com.datasystem.bookservice.service.BookService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/book")
public class BookController {

	public BookController(final BookService bookService) {
		this.bookService = bookService;
	}

	private final BookService bookService;

	@GetMapping
	@Operation(summary = "Get all books")
	public List<BookDto> getAllBooks() {
		return bookService.getAllBooks();
	}

	@PostMapping
	@Operation(summary = "Add new book")
	public void addBook(@RequestBody AddBookRequest request) {
		bookService.addBook(request);
	}

	@PutMapping
	@Operation(summary = "Borrow a book")
	public void borrowBook(@RequestParam String isbn, @RequestParam String clientName) {
		bookService.rentBook(isbn, clientName);
	}
}
