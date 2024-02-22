package com.datasystem.bookservice.model;

public record AddBookRequest(String title, String author, String isbn, String category) {
}
