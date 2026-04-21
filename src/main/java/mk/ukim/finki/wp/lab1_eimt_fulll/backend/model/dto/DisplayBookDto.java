package mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.dto;

import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.Book;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.enums.BookState;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.enums.Category;

import java.time.LocalDate;
import java.util.List;

public record DisplayBookDto(
        Long id,
        String name,
        Category category,
        String authorFullName,
        String country,
        BookState state,
        Integer availableCopies,
        LocalDate datePublished
) {

    public static DisplayBookDto from(Book book) {
        return new DisplayBookDto(
                book.getId(),
                book.getTitle(),
                book.getCategory(),
                book.getAuthor().getName() + " " + book.getAuthor().getSurname(),
                book.getAuthor().getCountry().getName(),
                book.getBookState(),
                book.getAvailableCopies(),
                book.getDatePublished()
        );
    }

    public static List<DisplayBookDto> from(List<Book> books) {
        return books
                .stream()
                .map(DisplayBookDto::from)
                .toList();
    }
}