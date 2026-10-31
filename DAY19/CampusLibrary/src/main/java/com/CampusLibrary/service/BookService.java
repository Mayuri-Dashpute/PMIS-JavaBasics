
package com.CampusLibrary.service;

import com.CampusLibrary.entity.Book;
import com.CampusLibrary.repository.BookRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Get all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Get book by ID
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    // Add book
    public Book addBook(Book book) {
        book.setId(null);
        return bookRepository.save(book);
    }

    // Update book
    public Optional<Book> updateBook(Long id, Book book) {

        Optional<Book> existingBook =
                bookRepository.findById(id);

        if (existingBook.isEmpty()) {
            return Optional.empty();
        }

        book.setId(id);

        return Optional.of(bookRepository.save(book));
    }

    // Delete book
    public boolean deleteBook(Long id) {
        return bookRepository.deleteById(id);
    }
}
