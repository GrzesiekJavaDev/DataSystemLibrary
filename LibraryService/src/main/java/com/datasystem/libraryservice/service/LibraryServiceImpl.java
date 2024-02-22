package com.datasystem.libraryservice.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.datasystem.libraryservice.repository.BookRepository;
import com.datasystem.libraryservice.model.entity.Book;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class LibraryServiceImpl implements LibraryService {

	private final BookRepository bookRepository;

	@Override
	public List<Book> getAllBorrowedBooks() {
		return bookRepository.findByBorrowerIsNotNull();
	}

	public void borrowBook(String isbn, String clientName) {
		bookRepository.findById(isbn).ifPresent(book -> {
			if (!StringUtils.isEmpty(book.getBorrower())) {
				log.info("The book with id: {} has already been borrowed", isbn);
			}
			book.setBorrower(clientName);
			bookRepository.save(book);
			log.info("Successfully borrowed a book with id: {}", isbn);
		});
	}
}
