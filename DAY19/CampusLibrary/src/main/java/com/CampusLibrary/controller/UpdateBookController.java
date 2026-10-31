
package com.CampusLibrary.controller;

import com.CampusLibrary.entity.Book;
import com.CampusLibrary.service.BookService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class UpdateBookController {

    private final BookService bookService;

    public UpdateBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<Book> updateBook(
            @PathVariable Long bookId,
            @RequestBody Book book) {

        return bookService.updateBook(bookId, book)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
