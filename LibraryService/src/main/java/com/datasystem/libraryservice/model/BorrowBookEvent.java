package com.datasystem.libraryservice.model;

public record BorrowBookEvent(String clientName, String isbn) {
}
