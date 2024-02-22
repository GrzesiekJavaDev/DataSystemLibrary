package com.datasystem.bookservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.datasystem.bookservice.exception.BookNotFoundException;
import com.datasystem.bookservice.mapper.BookMapper;
import com.datasystem.bookservice.model.AddBookRequest;
import com.datasystem.bookservice.model.BookDto;
import com.datasystem.bookservice.model.BorrowBookRequest;
import com.datasystem.bookservice.repository.BookRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

	private final BookMapper bookMapper;
	private final BookRepository bookRepository;
	private final BookProducerService bookProducerService;

	@Override
	public List<BookDto> getAllBooks() {
		return bookMapper.map(bookRepository.findAll());
	}

	@Override
	public void addBook(final AddBookRequest request) {
		var book = bookMapper.map(request);
		bookRepository.save(book);
		log.info("Book {} was added", request.title());
		bookProducerService.sendBookAdded(book);
	}

	@Override
	public void rentBook(String isbn, String clientName) {
		bookRepository.findById(isbn).orElseThrow(() -> new BookNotFoundException(isbn));
		bookProducerService.sendBookBorrowed(new BorrowBookRequest(clientName, isbn));
	}
}
