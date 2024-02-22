package com.datasystem.libraryservice.model.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book {

	@Id
	String isbn;
	String title;
	String author;
	String category;
	String borrower;
}