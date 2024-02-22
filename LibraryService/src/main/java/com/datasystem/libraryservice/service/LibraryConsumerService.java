package com.datasystem.libraryservice.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.datasystem.libraryservice.repository.BookRepository;
import com.datasystem.libraryservice.model.BorrowBookEvent;
import com.datasystem.libraryservice.model.entity.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class LibraryConsumerService {

	private final ObjectMapper objectMapper = new ObjectMapper();
	private final BookRepository bookRepository;
	private final LibraryService libraryService;

	@KafkaListener(topics = "add-book-topic", groupId = "book-management-service-group")
	public void receiveBookAdded(String message) {
		try {
			Book book = objectMapper.readValue(message, Book.class);
			bookRepository.save(book);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	@KafkaListener(topics = "rent-book-topic", groupId = "book-management-service-group")
	public void receiveBookBorrowed(String message) {
		try {
			BorrowBookEvent rentBookEvent = objectMapper.readValue(message, BorrowBookEvent.class);
			libraryService.borrowBook(rentBookEvent.isbn(), rentBookEvent.clientName());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
