package mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.dto;




import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.Author;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.Book;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.enums.BookState;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.enums.Category;

import java.time.LocalDate;


public record BookCreateDto(

        @NotNull
        String name,

        @NotNull
        Category category,

        Long authorId,

        @Min(0)
        Integer availableCopies,
        LocalDate datePublished,
        BookState bookState

) {

    public Book toBook(Author author) {
        Book book = new Book();

        book.setTitle(name);
        book.setCategory(category);
        book.setAuthor(author);
        book.setAvailableCopies(availableCopies);
        book.setBookState(bookState != null ? bookState : BookState.GOOD);
        book.setDatePublished(datePublished);
        return book;
    }
}

