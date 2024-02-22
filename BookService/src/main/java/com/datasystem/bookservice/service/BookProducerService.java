package com.datasystem.bookservice.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.datasystem.bookservice.model.BorrowBookRequest;
import com.datasystem.bookservice.model.entity.Book;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookProducerService {

	private final KafkaTemplate<String, Object> kafkaTemplate;

	private static final String ADD_BOOK_TOPIC = "add-book-topic";
	private static final String RENT_BOOK_TOPIC = "rent-book-topic";

	public void sendBookAdded(Book book) {
		kafkaTemplate.send(ADD_BOOK_TOPIC, book);
	}

	public void sendBookBorrowed(BorrowBookRequest rentBookRequest) {
		kafkaTemplate.send(RENT_BOOK_TOPIC, rentBookRequest);
	}
}
