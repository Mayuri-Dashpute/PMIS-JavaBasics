package com.prac.question6;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {

    public List<Book> findByTitleAndAuthor(String title, String author) {
        String titlePrefix = title.toLowerCase(Locale.ROOT);
        String authorPrefix = author == null ? null : author.toLowerCase(Locale.ROOT);

        return BookData.books().stream()
                .filter(book -> book.title().toLowerCase(Locale.ROOT).startsWith(titlePrefix))
                .filter(book -> authorPrefix == null
                        || authorPrefix.isBlank()
                        || book.author().toLowerCase(Locale.ROOT).startsWith(authorPrefix))
                .toList(); // TODO: filter BookData.books() by title prefix and optional author prefix
        return List.of();
    }
}
