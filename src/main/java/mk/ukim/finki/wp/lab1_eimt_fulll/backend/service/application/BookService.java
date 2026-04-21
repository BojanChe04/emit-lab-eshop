package mk.ukim.finki.wp.lab1_eimt_fulll.backend.service.application;

import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.Book;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.dto.BookCreateDto;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.dto.DisplayBookDto;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.projection.BookDetailsProjection;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.projection.BookShortProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<DisplayBookDto> findAll();
    Optional<DisplayBookDto> save(BookCreateDto bookCreateDto);
    Optional<DisplayBookDto> update(Long id, BookCreateDto bookCreateDto);
    void delete (Long id);
    Book rent (Long id);

    Page<DisplayBookDto> findAll(int page, int size, String sortBy);

    List<BookShortProjection> findAllShort();
    List<BookDetailsProjection> findAllDetails();

    List<Book> getAllBooksWithAuthorAndCountry();

    List<DisplayBookDto> findTop10Newest();
}