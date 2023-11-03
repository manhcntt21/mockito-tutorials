package com.example.argumentmatcher;

/**
 * @author manhdt14
 * created in 11/4/2023 4:03 AM
 */
public class BookService {
    public boolean isValidBook(String title, int yearPublished) {
        return title != null && !title.trim().isEmpty() && yearPublished > 0;
    }
}