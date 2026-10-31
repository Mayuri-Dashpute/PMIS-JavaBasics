
package com.CampusLibrary.controller;

import com.CampusLibrary.entity.Book;
import com.CampusLibrary.service.BookService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class GetBookByIdController {

    private final BookService bookService;

    public GetBookByIdController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<Book> getBookById(
            @PathVariable Long bookId) {

        return bookService.getBookById(bookId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
