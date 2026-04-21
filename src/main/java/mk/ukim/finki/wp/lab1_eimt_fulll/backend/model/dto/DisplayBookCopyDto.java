package mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.dto;

import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.BookCopy;

import java.util.List;

public record DisplayBookCopyDto(
        Long id,
        Long bookId,
        String bookTitle,
        Boolean rented
) {

    public static DisplayBookCopyDto from(BookCopy copy) {
        return new DisplayBookCopyDto(
                copy.getId(),
                copy.getBook().getId(),
                copy.getBook().getTitle(),
                copy.getRented()
        );
    }

    public static List<DisplayBookCopyDto> from(List<BookCopy> copies) {
        return copies.stream()
                .map(DisplayBookCopyDto::from)
                .toList();
    }
}
