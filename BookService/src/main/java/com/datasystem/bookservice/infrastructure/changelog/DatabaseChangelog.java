package com.datasystem.bookservice.infrastructure.changelog;

import java.util.Arrays;

import com.datasystem.bookservice.model.entity.Book;
import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.github.cloudyrock.mongock.driver.mongodb.springdata.v3.decorator.impl.MongockTemplate;

@ChangeLog(order = "001")
public class DatabaseChangelog {

	@ChangeSet(order = "001", id = "addBooks", author = "ja")
	public void addBooks(MongockTemplate mongoTemplate) {
		mongoTemplate.insertAll(Arrays.asList(
			new Book("978-0544003415", "Władca Pierścieni: Drużyna Pierścienia", "J.R.R. Tolkien", "Fantasy"),
			new Book("978-0547928227", "Hobbit, czyli tam i z powrotem", "J.R.R. Tolkien", "Fantasy"),
			new Book("978-0747532699", "Harry Potter i Kamień Filozoficzny", "J.K. Rowling", "Fantasy"),
			new Book("978-0553593716", "Gra o tron", "George R.R. Martin", "Fantasy"),
			new Book("978-0061120084", "Zabić drozda", "Harper Lee", "Klasyczna")
		));
	}
}
