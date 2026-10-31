
package com.CampusLibrary.controller;

import com.CampusLibrary.entity.Book;
import com.CampusLibrary.service.BookService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class AddBookController {

    private final BookService bookService;

    public AddBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }
}
