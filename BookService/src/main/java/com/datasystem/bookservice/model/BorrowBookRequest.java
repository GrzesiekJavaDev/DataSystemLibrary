package com.datasystem.bookservice.model;

public record BorrowBookRequest(String clientName, String isbn) {
}
