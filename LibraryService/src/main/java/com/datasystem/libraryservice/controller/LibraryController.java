package com.datasystem.libraryservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datasystem.libraryservice.model.entity.Book;
import com.datasystem.libraryservice.service.LibraryService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class LibraryController {

	private final LibraryService libraryService;

	@GetMapping("/book")
	@Operation(summary = "Get all borrowed books")
	public List<Book> getAllBorrowedBooks() {
		return libraryService.getAllBorrowedBooks();
	}
}
