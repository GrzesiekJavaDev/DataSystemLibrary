package com.datasystem.bookservice.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BookDto {
	private String title;
	private String author;
	private String isbn;
	private String category;
}
