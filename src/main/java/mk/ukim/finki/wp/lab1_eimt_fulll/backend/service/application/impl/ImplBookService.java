package mk.ukim.finki.wp.lab1_eimt_fulll.backend.service.application.impl;

import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.Author;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.Book;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.dto.BookCreateDto;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.dto.DisplayBookDto;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.exeptions.AuthorNotFoundException;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.exeptions.BookNotFoundException;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.projection.BookDetailsProjection;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.model.projection.BookShortProjection;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.repository.AuthorRepository;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.repository.BookRepository;
import mk.ukim.finki.wp.lab1_eimt_fulll.backend.service.application.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ImplBookService implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public ImplBookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<DisplayBookDto> findAll() {
        return DisplayBookDto.from(bookRepository.findAll());
    }


    @Override
    public Optional<DisplayBookDto> save(BookCreateDto dto) {

        Author author = authorRepository
                .findById(Long.valueOf(dto.authorId()))
                .orElse(null);

        if (author == null) {
            return Optional.empty();
        }

        Book book = bookRepository.save(dto.toBook(author));

        return Optional.of(DisplayBookDto.from(book));
    }

    @Override
    public Optional<DisplayBookDto> update(Long id, BookCreateDto createBookDto) {

        Author author = authorRepository
                .findById(Long.valueOf(createBookDto.authorId()))
                .orElseThrow(() -> new AuthorNotFoundException(Math.toIntExact(createBookDto.authorId())));

        return bookRepository
                .findById(id)
                .map(book -> {
                    book.setTitle(createBookDto.name());
                    book.setCategory(createBookDto.category());
                    book.setAuthor(author);
                    book.setAvailableCopies(createBookDto.availableCopies());
                    book.setDatePublished(createBookDto.datePublished());
                    return bookRepository.save(book);
                })
                .map(DisplayBookDto::from);
    }

    @Override
    public void delete(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        bookRepository.delete(book);
    }

    @Override
    public Book rent(Long id) {
        Book book = bookRepository.findById(id).orElseThrow();
        if (book.getAvailableCopies() > 0) {
            book.setAvailableCopies(book.getAvailableCopies() - 1);
        }
        return bookRepository.save(book);
    }

    @Override
    public Page<DisplayBookDto> findAll(int page, int size, String sortBy) {

        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by(sortBy).ascending()
        );

        return bookRepository.findAll(pageable)
                .map(DisplayBookDto::from);
    }

    @Override
    public List<BookShortProjection> findAllShort() {
        return bookRepository.findAllBy();
    }

    @Override
    public List<BookDetailsProjection> findAllDetails() {
        return bookRepository.findAllDetailedBy();
    }

    @Override
    public List<Book> getAllBooksWithAuthorAndCountry() {
        return bookRepository.findAllWithAuthorAndCountry();
    }

    @Override
    public List<DisplayBookDto> findTop10Newest() {
        return DisplayBookDto.from(
                bookRepository.findTop10ByOrderByDatePublishedDesc()
        );
    }
}

