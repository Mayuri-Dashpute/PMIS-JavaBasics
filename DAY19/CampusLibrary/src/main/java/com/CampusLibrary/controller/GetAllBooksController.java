
package com.CampusLibrary.controller;

import com.CampusLibrary.entity.Book;
import com.CampusLibrary.service.BookService;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
public class GetAllBooksController {

    private final BookService bookService;

    public GetAllBooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
}
