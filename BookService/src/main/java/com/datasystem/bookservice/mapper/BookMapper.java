package com.datasystem.bookservice.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.datasystem.bookservice.model.AddBookRequest;
import com.datasystem.bookservice.model.BookDto;
import com.datasystem.bookservice.model.entity.Book;

@Mapper
public interface BookMapper {

	List<BookDto> map(List<Book> books);

	BookDto map(Book book);

	Book map(AddBookRequest book);
}
