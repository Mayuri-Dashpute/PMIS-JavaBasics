
package com.CampusLibrary.repository;

import com.CampusLibrary.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {

    private final List<Book> books = new ArrayList<>();

    private Long idCounter = 1L;

    // Get all books
    public List<Book> findAll() {
        return books;
    }

    // Get book by ID
    public Optional<Book> findById(Long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
    }

    // Add or update book
    public Book save(Book book) {

        if (book.getId() == null) {
            book.setId(idCounter++);
            books.add(book);
            return book;
        }

        Optional<Book> existingBook = findById(book.getId());

        if (existingBook.isPresent()) {
            books.remove(existingBook.get());
        }

        books.add(book);

        return book;
    }

    // Delete book
    public boolean deleteById(Long id) {
        return books.removeIf(book -> book.getId().equals(id));
    }
}
